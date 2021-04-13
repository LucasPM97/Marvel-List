package com.lucas.marvellist.services

import com.lucas.marvellist.models.GetCharactersResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface HeroService {
    @GET("characters")
    suspend fun getCharacters() : Response<GetCharactersResponseModel>
}