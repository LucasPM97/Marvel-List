package com.lucas.marvellist.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                createMarvelApiClient()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val CHARACTERS_SERVICE: CharactersService = getRetrofit().create(CharactersService::class.java)
    val eventsService: EventsService = getRetrofit().create(EventsService::class.java)
}