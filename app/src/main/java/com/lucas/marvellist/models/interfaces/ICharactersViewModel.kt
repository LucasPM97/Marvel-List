package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.repositories.characters.ICharactersRepository

interface ICharactersViewModel {
    val characters: MutableLiveData<List<Character>>

    val repository: ICharactersRepository

}