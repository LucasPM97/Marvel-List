package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData
import com.lucas.marvellist.models.Hero

interface ICharacterDetailsViewModel {
    fun setUp(character: Hero)

    val isLoading: MutableLiveData<Boolean>

    val hero: MutableLiveData<Hero>
}