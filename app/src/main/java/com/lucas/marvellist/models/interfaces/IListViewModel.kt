package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData

interface IListViewModel {

    val isLoading: MutableLiveData<Boolean>

    val error: MutableLiveData<Boolean>

    fun loadScreenIfNeeded()

    fun needsToLoadScreen(): Boolean

    fun loadMoreItems()

    fun shouldLoadMore(): Boolean

}