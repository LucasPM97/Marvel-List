package com.lucas.marvellist.models

import com.google.gson.annotations.SerializedName
import com.lucas.marvellist.utils.extensions.formatHttpUrlToHttps

data class ImageThumbnail(
        private val path: String,
        private val extension: String

) {

    private val url: String
        get() = path.formatHttpUrlToHttps()

    fun getSmallImageUrl(): String {
        return "${url}/standard_large.${extension}"
    }
}
