package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.repositories.heroList.IHeroListRepository

interface IHeroListViewModel {
    val heroList: MutableLiveData<List<Character>>

    val repository: IHeroListRepository

}