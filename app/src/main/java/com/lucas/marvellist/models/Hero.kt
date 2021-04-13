package com.lucas.marvellist.models

data class Hero(
        val id: String = "",
        val name: String = "",
        val description: String = "",
        val thumbnail: ImageThumbnail? = null
)