package com.lucas.marvellist.repositories.events

import com.lucas.marvellist.models.Event

interface IEventsRepository {

    suspend fun getEvents(offSet: Int): List<Event>?

}