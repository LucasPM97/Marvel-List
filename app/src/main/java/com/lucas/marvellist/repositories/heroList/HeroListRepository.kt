package com.lucas.marvellist.repositories.heroList

import com.lucas.marvellist.models.Hero
import com.lucas.marvellist.services.HeroService

class HeroListRepository(private val heroApiService: HeroService) : IHeroListRepository {

    override suspend fun getCharacters(offSet: Int): List<Hero>? {

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