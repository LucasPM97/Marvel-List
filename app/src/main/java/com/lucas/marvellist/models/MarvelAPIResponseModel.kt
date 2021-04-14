package com.lucas.marvellist.models

data class MarvelAPIResponseModel<T>(
    val data: Data<T>
)

data class Data<T>(
    val results: T
)
