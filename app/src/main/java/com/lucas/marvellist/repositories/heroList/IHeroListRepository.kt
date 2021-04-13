package com.lucas.marvellist.repositories.heroList

import com.lucas.marvellist.models.Hero

interface IHeroListRepository {

    suspend fun getCharacters(offSet: Int): List<Hero>?

}