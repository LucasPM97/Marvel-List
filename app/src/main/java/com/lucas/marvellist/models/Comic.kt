package com.lucas.marvellist.models

import android.os.Parcel
import android.os.Parcelable
import androidx.core.text.isDigitsOnly
import java.lang.Exception

data class Comic(
    val name: String? = "",
) : Parcelable {

    fun getComicYear(): String {

        try {
            if (name.isNullOrEmpty()) return ""

            val year = name.substring(name.indexOf("(") + 1, name.indexOf(")"))

            if (year.isDigitsOnly()) return year

        } catch (ex: Exception) {
            println(ex)
        }

        return ""
    }

    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comic> {
        override fun createFromParcel(parcel: Parcel): Comic {
            return Comic(parcel)
        }

        override fun newArray(size: Int): Array<Comic?> {
            return arrayOfNulls(size)
        }
    }
}