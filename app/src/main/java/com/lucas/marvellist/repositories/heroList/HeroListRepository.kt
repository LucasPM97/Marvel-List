package com.lucas.marvellist.repositories.heroList

import com.lucas.marvellist.models.Hero
import com.lucas.marvellist.services.HeroService

class HeroListRepository(private val heroApiService: HeroService) : IHeroListRepository {

    override suspend fun getCharacters(): List<Hero>? {

        try {
            val response = heroApiService.getCharacters()

            if (response.isSuccessful) {
                return response.body()?.data?.results
            }

        } catch (ex: Exception) {
            println(ex)
        }

        return null
    }

}