package com.lucas.marvellist.ui.hero_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.models.genericViewModels.BaseListViewModel
import com.lucas.marvellist.models.interfaces.IHeroListViewModel
import com.lucas.marvellist.repositories.heroList.HeroListRepository
import com.lucas.marvellist.services.RetrofitBuilder
import com.lucas.marvellist.utils.extensions.addRange
import kotlinx.coroutines.launch

class HeroListViewModel : BaseListViewModel(), IHeroListViewModel {

    override val heroList = MutableLiveData<List<Character>>()
    override val repository = HeroListRepository(
        RetrofitBuilder.heroService
    )

    override fun loadScreenIfNeeded() {
        if (needsToLoadScreen()) {
            viewModelScope.launch {
                val result = loadItems(0)

                if (!result.isNullOrEmpty()) {
                    heroList.value = result
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
                }
            }
        }
    }

    private suspend fun loadItems(offSet: Int): List<Character>? {
        showHideError(false)
        showHideLoading(true)
        try {
            val result = repository.getCharacters(offSet)

            if (result.isNullOrEmpty()) {
                showHideError(true)
            }

            return result
        } finally {
            showHideLoading(false)
        }
    }


    override fun shouldLoadMore(): Boolean =
        !heroList.value.isNullOrEmpty() && !isLoading.value!!

}