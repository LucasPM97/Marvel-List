package com.lucas.marvellist.ui.events

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.models.genericViewModels.BaseListViewModel
import com.lucas.marvellist.models.interfaces.IEventsViewModel
import com.lucas.marvellist.repositories.events.EventsRepository
import com.lucas.marvellist.services.RetrofitBuilder
import com.lucas.marvellist.utils.extensions.addRange
import kotlinx.coroutines.launch

class EventsViewModel : BaseListViewModel(), IEventsViewModel {

    override val eventList = MutableLiveData<List<Event>>()

    override val repository = EventsRepository(
        RetrofitBuilder.eventsService
    )

    override fun loadScreenIfNeeded() {
        if (needsToLoadScreen()) {
            viewModelScope.launch {
                val result = loadItems(0)

                if (!result.isNullOrEmpty()) {
                    eventList.value = result
                }
            }
        }
    }

    override fun needsToLoadScreen(): Boolean = eventList.value.isNullOrEmpty()

    override fun loadMoreItems() {
        if (shouldLoadMore()) {
            viewModelScope.launch {
                val result = loadItems(eventList.value!!.count())

                if (!result.isNullOrEmpty()) {
                    eventList.addRange(result)
                }
            }
        }
    }

    private suspend fun loadItems(offSet: Int): List<Event>? {
        showHideError(false)
        showHideLoading(true)
        try {
            val result = repository.getEvents(offSet)

            if (result.isNullOrEmpty()) {
                showHideError(true)
            }

            return result
        } finally {
            showHideLoading(false)
        }
    }


    override fun shouldLoadMore(): Boolean =
        !eventList.value.isNullOrEmpty() && !isLoading.value!!
}