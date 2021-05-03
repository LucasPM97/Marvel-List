package com.lucas.marvellist.repositories.events

import com.lucas.marvellist.models.Event
import com.lucas.marvellist.services.EventsService

class EventsRepository(private val eventsApiService: EventsService) : IEventsRepository {

    override suspend fun getEvents(offSet: Int): List<Event>? {

        try {
            val response = eventsApiService.getEvents(offSet)

            if (response.isSuccessful) {
                return response.body()?.data?.results
            }

        } catch (ex: Exception) {
            println(ex)
        }

        return null
    }

}