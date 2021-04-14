package com.lucas.marvellist.models

import android.os.Parcel
import android.os.Parcelable

data class Hero(
        val id: String? = "",
        val name: String? = "",
        val description: String? = "",
        val thumbnail: ImageThumbnail? = null
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readParcelable(ImageThumbnail::class.java.classLoader)
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(id)
                parcel.writeString(name)
                parcel.writeString(description)
                parcel.writeParcelable(thumbnail, flags)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Hero> {
                override fun createFromParcel(parcel: Parcel): Hero {
                        return Hero(parcel)
                }

                override fun newArray(size: Int): Array<Hero?> {
                        return arrayOfNulls(size)
                }
        }
}