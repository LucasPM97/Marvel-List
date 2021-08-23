package com.lucas.marvellist.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.models.genericViewModels.BaseListViewModel
import com.lucas.marvellist.models.interfaces.ICharactersViewModel
import com.lucas.marvellist.repositories.characters.CharactersRepository
import com.lucas.marvellist.services.RetrofitBuilder
import com.lucas.marvellist.utils.extensions.addRange
import kotlinx.coroutines.launch

class CharactersViewModel : BaseListViewModel(), ICharactersViewModel {

    override val characters = MutableLiveData<List<Character>>()
    override val repository = CharactersRepository(
        RetrofitBuilder.CHARACTERS_SERVICE
    )

    override fun loadScreenIfNeeded() {
        if (needsToLoadScreen()) {
            viewModelScope.launch {
                val result = loadItems(0)

                if (!result.isNullOrEmpty()) {
                    characters.value = result
                }
            }
        }
    }

    override fun needsToLoadScreen(): Boolean = characters.value.isNullOrEmpty()

    override fun loadMoreItems() {
        if (shouldLoadMore()) {
            viewModelScope.launch {
                val result = loadItems(characters.value!!.count())

                if (!result.isNullOrEmpty()) {
                    characters.addRange(result)
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
        !characters.value.isNullOrEmpty() && !isLoading.value!!

}