package com.lucas.marvellist.models.interfaces

import com.facebook.AccessToken
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

interface IAuthenticationManager {
    suspend fun loginWithFirebaseFacebook(accessToken: AccessToken): AuthResult?

    fun authStateListener(listener: FirebaseAuth.AuthStateListener)

    fun facebooklogOut()
}