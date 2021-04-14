package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.repositories.events.EventsRepository

interface IEventsViewModel {
    val eventList: MutableLiveData<List<Event>>

    val repository: EventsRepository

}