package com.lucas.marvellist.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.AccessToken
import com.facebook.login.LoginManager
import com.lucas.marvellist.utils.AuthenticationManager
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val error = MutableLiveData<Boolean>()

    init {
        showHideErrorMessage(false)
    }

    fun loginWithFacebookCredentials(accessToken: AccessToken) {
        viewModelScope.launch {

            val result = AuthenticationManager.loginWithFirebaseFacebook(accessToken)

            if (result == null) {
                // If sign in fails, display a message to the user.
                showHideErrorMessage(true)
                AuthenticationManager.facebooklogOut()
            }
        }
    }

    fun showHideErrorMessage(visible: Boolean) {
        error.value = visible
    }
}