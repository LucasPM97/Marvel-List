package com.lucas.marvellist.services

import com.lucas.marvellist.models.Event
import com.lucas.marvellist.models.MarvelAPIResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EventsService {
    @GET("events")
    suspend fun getEvents(
        @Query("offset") offset: Int
    ): Response<MarvelAPIResponseModel<List<Event>>>
}