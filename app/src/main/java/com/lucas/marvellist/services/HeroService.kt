package com.lucas.marvellist.services

import com.lucas.marvellist.models.Hero
import com.lucas.marvellist.models.MarvelAPIResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int
    ): Response<MarvelAPIResponseModel<List<Hero>>>
}