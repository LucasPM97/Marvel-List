package com.lucas.marvellist.models.genericViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucas.marvellist.models.interfaces.IListViewModel

abstract class BaseListViewModel : ViewModel(), IListViewModel {

    override val isLoading = MutableLiveData<Boolean>()
    override val error = MutableLiveData<Boolean>()

    init {
        showHideLoading(false)
        showHideError(false)
    }

    protected fun showHideError(visible: Boolean) {
        error.value = visible
    }

    protected fun showHideLoading(visible: Boolean) {
        isLoading.value = visible
    }
}