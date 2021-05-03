package com.lucas.marvellist.models

import android.os.Parcel
import android.os.Parcelable

data class ComicCollection(
    val items: List<Comic>? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Comic)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(items)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ComicCollection> {
        override fun createFromParcel(parcel: Parcel): ComicCollection {
            return ComicCollection(parcel)
        }

        override fun newArray(size: Int): Array<ComicCollection?> {
            return arrayOfNulls(size)
        }
    }
}
