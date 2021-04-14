package com.lucas.marvellist.ui.character_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucas.marvellist.models.Hero
import com.lucas.marvellist.models.interfaces.ICharacterDetailsViewModel

class CharacterDetailsViewModel : ViewModel(), ICharacterDetailsViewModel {
    override val isLoading = MutableLiveData<Boolean>()
    override val hero = MutableLiveData<Hero>()

    override fun setUp(character: Hero) {
        hero.value = character
    }

}