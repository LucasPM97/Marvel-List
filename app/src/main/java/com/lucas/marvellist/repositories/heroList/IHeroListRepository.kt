package com.lucas.marvellist.repositories.heroList

import com.lucas.marvellist.models.Character

interface IHeroListRepository {

    suspend fun getCharacters(offSet: Int): List<Character>?

}