package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData
import com.lucas.marvellist.models.Hero

interface IHeroListViewModel {
    val heroList: MutableLiveData<List<Hero>>
}