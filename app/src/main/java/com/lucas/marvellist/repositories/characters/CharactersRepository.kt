package com.lucas.marvellist.repositories.characters

import com.lucas.marvellist.models.Character
import com.lucas.marvellist.services.CharactersService

class CharactersRepository(private val charactersApiService: CharactersService) : ICharactersRepository {

    override suspend fun getCharacters(offSet: Int): List<Character>? {

        try {
            val response = charactersApiService.getCharacters(offSet)

            if (response.isSuccessful) {
                return response.body()?.data?.results
            }

        } catch (ex: Exception) {
            println(ex)
        }

        return null
    }

}