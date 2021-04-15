package com.lucas.marvellist.models

import com.lucas.marvellist.utils.extensions.*

data class Event(
    val title: String,
    private val start: String?,
    private val end: String?,
    val thumbnail: ImageThumbnail? = null,
) {
    fun getStartDate(): String {
        return start?.toSimplifiedDateString() ?: ""
    }

    fun getEndDate(): String {
        return end?.toSimplifiedDateString() ?: ""
    }

    fun getSmallImageUrl(): String {
        return thumbnail?.getSmallImageUrl() ?: ""
    }
}

