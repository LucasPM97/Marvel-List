package com.lucas.marvellist.ui.hero_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.marvellist.models.Hero
import com.lucas.marvellist.models.interfaces.IHeroListViewModel
import com.lucas.marvellist.models.interfaces.IListViewModel
import com.lucas.marvellist.services.RetrofitBuilder
import com.lucas.marvellist.repositories.heroList.HeroListRepository
import com.lucas.marvellist.utils.extensions.addRange
import kotlinx.coroutines.launch

class HeroListViewModel : ViewModel(), IHeroListViewModel, IListViewModel {

    override val heroList = MutableLiveData<List<Hero>>()
    override val repository = HeroListRepository(
            RetrofitBuilder.heroService
    )
    override val isLoading = MutableLiveData<Boolean>()

    override fun loadScreenIfNeeded() {
        if (needsToLoadScreen()) {
            viewModelScope.launch {
                val result = loadItems(0)

                if (!result.isNullOrEmpty()) {
                    heroList.value = result
                } else {
                    //TODO: Show error
                }
            }
        }
    }

    override fun needsToLoadScreen(): Boolean = heroList.value.isNullOrEmpty()

    override fun loadMoreItems() {
        if (shouldLoadMore()) {
            viewModelScope.launch {
                val result = loadItems(heroList.value!!.count())


                if (!result.isNullOrEmpty()) {
                    heroList.addRange(result)
                } else {
                    //TODO: Show error
                }
            }
        }
    }

    private suspend fun loadItems(offSet: Int): List<Hero>? {
        showHideLoading(true)
        try {
            return repository.getCharacters(offSet)
        } finally {
            showHideLoading(false)
        }
    }

    private fun showHideLoading(visible: Boolean) {
        isLoading.value = visible
    }

    override fun shouldLoadMore(): Boolean {
        return !heroList.value.isNullOrEmpty() && !(isLoading.value ?: true)
    }

}