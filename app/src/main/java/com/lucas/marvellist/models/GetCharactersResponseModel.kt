package com.lucas.marvellist.models

data class GetCharactersResponseModel(
        val data: Data
)

data class Data(
        val results: List<Hero>
)
