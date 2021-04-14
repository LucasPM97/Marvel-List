package com.lucas.marvellist.models

data class Event(
    val title: String,
    private val start: String,
    private val end: String,
    val thumbnail: ImageThumbnail? = null,
) {
    fun getStartDate(): String {
        return start
    }

    fun getEndDate(): String {
        return end
    }

    fun getSmallImageUrl(): String {
        return thumbnail?.getSmallImageUrl() ?: ""
    }

    fun getBigImageUrl(): String {
        return thumbnail?.getBigImageUrl() ?: ""
    }
}
