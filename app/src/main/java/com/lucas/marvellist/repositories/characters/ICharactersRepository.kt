package com.lucas.marvellist.repositories.characters

import com.lucas.marvellist.models.Character

interface ICharactersRepository {

    suspend fun getCharacters(offSet: Int): List<Character>?

}