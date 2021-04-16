package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData
import com.facebook.AccessToken

interface ILoginViewModel {

    val error: MutableLiveData<Boolean>

    fun loginWithFacebookCredentials(accessToken: AccessToken)

    fun showHideErrorMessage(visible: Boolean)
}