package com.lucas.marvellist.repositories.heroList

import com.lucas.marvellist.models.Character
import com.lucas.marvellist.services.HeroService

class HeroListRepository(private val heroApiService: HeroService) : IHeroListRepository {

    override suspend fun getCharacters(offSet: Int): List<Character>? {

        try {
            val response = heroApiService.getCharacters(offSet)

            if (response.isSuccessful) {
                return response.body()?.data?.results
            }

        } catch (ex: Exception) {
            println(ex)
        }

        return null
    }

}