package com.lucas.marvellist.models.interfaces

import androidx.lifecycle.MutableLiveData
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.repositories.events.IEventsRepository

interface IEventsViewModel {
    val eventList: MutableLiveData<List<Event>>

    val repository: IEventsRepository

}