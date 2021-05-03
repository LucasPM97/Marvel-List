package com.lucas.marvellist.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.android.material.snackbar.Snackbar
import com.lucas.marvellist.R
import com.lucas.marvellist.UserViewModel
import com.lucas.marvellist.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        const val LOGIN_SUCCESSFUL: String = "LOGIN_SUCCESSFUL"
        const val FACEBOOK_SIGNUP_RC = 202
    }

    private lateinit var binding: FragmentLoginBinding

    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var savedStateHandle: SavedStateHandle

    private val loginViewModel: LoginViewModel by viewModels()

    private val callbackManager = CallbackManager.Factory.create();

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

        savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
        savedStateHandle.set(LOGIN_SUCCESSFUL, false)

        binding.loginButton.apply {
            setReadPermissions("email")
            fragment = this@LoginFragment
            registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult?) {
                    result?.let {
                        loginViewModel.loginWithFacebookCredentials(result.accessToken)
                    }
                }

                override fun onCancel() {}
                override fun onError(error: FacebookException?) {
                    loginViewModel.showHideErrorMessage(true)
                }
            })
        }

        implementViewModelObservers()
    }

    private fun implementViewModelObservers() {
        userViewModel.user.observe(viewLifecycleOwner, { result ->
            result?.let {
                loginSucceeded()
            }
        })
        loginViewModel.error.observe(viewLifecycleOwner, { visible ->
            visible?.let {
                if (it) showErrorMessage()
            }
        })
    }

    private fun loginSucceeded() {
        savedStateHandle.set(LOGIN_SUCCESSFUL, true)
        findNavController().popBackStack()
    }

    private fun showErrorMessage() {
        Snackbar.make(
            binding.root,
            "There was a problem trying to connect with our servers, please try again",
            Snackbar.LENGTH_LONG
        ).show()
        loginViewModel.showHideErrorMessage(false)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}