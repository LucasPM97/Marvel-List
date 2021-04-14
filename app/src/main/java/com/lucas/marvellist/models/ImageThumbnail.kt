package com.lucas.marvellist.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.lucas.marvellist.utils.extensions.formatHttpUrlToHttps

data class ImageThumbnail(
    private val path: String?,
    private val extension: String?

) : Parcelable {

    private val url: String
        get() = path?.formatHttpUrlToHttps() ?: ""

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    fun getSmallImageUrl(): String {
        return "${url}/standard_large.${extension}"
    }

    fun getBigImageUrl(): String {
        return "${url}.${extension}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(path)
        parcel.writeString(extension)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageThumbnail> {
        override fun createFromParcel(parcel: Parcel): ImageThumbnail {
            return ImageThumbnail(parcel)
        }

        override fun newArray(size: Int): Array<ImageThumbnail?> {
            return arrayOfNulls(size)
        }
    }
}
