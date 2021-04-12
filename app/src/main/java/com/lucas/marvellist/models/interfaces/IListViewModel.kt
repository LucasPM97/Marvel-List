package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData

interface IListViewModel {

    val isLoadingScreen : MutableLiveData<Boolean>

    fun loadScreenIfNeeded()

    fun needsToLoadScreen(): Boolean
}