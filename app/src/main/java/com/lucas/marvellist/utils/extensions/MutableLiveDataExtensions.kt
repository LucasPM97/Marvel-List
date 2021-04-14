package com.lucas.marvellist.utils.extensions

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<List<T>>.addRange(items: List<T>?) {
    items?.let {
        val newList = this.value ?: emptyList()
        this.value = newList + items
    }
}
