package com.lucas.marvellist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.lucas.marvellist.utils.AuthenticationManager

class UserViewModel : ViewModel() {

    var user = MutableLiveData<FirebaseUser?>()

    init {
        AuthenticationManager.authStateListener {
            user.value = it.currentUser
        }
    }

}