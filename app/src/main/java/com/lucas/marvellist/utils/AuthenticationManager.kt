package com.lucas.marvellist.utils

import com.facebook.AccessToken
import com.facebook.login.LoginManager
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lucas.marvellist.utils.extensions.awaitTaskResult
import java.lang.Exception

class AuthenticationManager private constructor() {

    private val firebaseAuth = Firebase.auth

    private object HOLDER {
        val INSTANCE = AuthenticationManager()
    }

    companion object {

        private val instance: AuthenticationManager by lazy { HOLDER.INSTANCE }

        suspend fun loginWithFirebaseFacebook(accessToken: AccessToken): AuthResult? {
            return try {
                awaitLoginWithFirebaseFacebook(accessToken)
            } catch (ex: Exception) {
                null
            }
        }

        private suspend fun awaitLoginWithFirebaseFacebook(accessToken: AccessToken): AuthResult? {
            val credential = FacebookAuthProvider.getCredential(accessToken.token)
            return awaitTaskResult(instance.firebaseAuth.signInWithCredential(credential))
        }

        fun authStateListener(listener: FirebaseAuth.AuthStateListener) =
            instance.firebaseAuth.addAuthStateListener(listener)

        fun facebooklogOut() {
            LoginManager.getInstance().logOut()
        }
    }
}