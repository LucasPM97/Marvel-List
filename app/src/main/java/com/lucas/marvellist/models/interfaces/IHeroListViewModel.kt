package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData
import com.lucas.marvellist.models.Hero
import com.lucas.marvellist.repositories.heroList.HeroListRepository

interface IHeroListViewModel {
    val heroList: MutableLiveData<List<Hero>>

    val repository: HeroListRepository

}