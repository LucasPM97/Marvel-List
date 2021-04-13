package com.lucas.marvellist.ui.hero_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.marvellist.models.Hero
import com.lucas.marvellist.models.interfaces.IHeroListViewModel
import com.lucas.marvellist.models.interfaces.IListViewModel
import com.lucas.marvellist.services.RetrofitBuilder
import com.lucas.marvellist.repositories.heroList.HeroListRepository
import kotlinx.coroutines.launch

class HeroListViewModel : ViewModel(), IHeroListViewModel, IListViewModel {

    override val heroList = MutableLiveData<List<Hero>>()
    override val repository = HeroListRepository(
        RetrofitBuilder.heroService
    )
    override val isLoadingScreen = MutableLiveData<Boolean>()

    override fun loadScreenIfNeeded() {
        if (needsToLoadScreen()){
            viewModelScope.launch {
                val result = repository.getCharacters()

                if (!result.isNullOrEmpty()){
                    heroList.value = result
                }
                else{
                    //TODO: Show error
                }
            }
        }
    }

    override fun needsToLoadScreen(): Boolean {
        val isNull = heroList.value == null
        val isEmpty = heroList.value?.isEmpty() == true

        return isNull || isEmpty
    }

}