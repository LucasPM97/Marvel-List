package com.lucas.marvellist.utils.extensions

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun String.md5(): ByteArray =
    MessageDigest.getInstance("MD5").digest(this.toByteArray(Charsets.UTF_8))

fun String.formatHttpUrlToHttps(): String {
    return this.replace("http", "https")
}

fun String.toSimplifiedDateString(): String? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        this.toLocalDateTime()?.parseToSimplifiedString()
    } else {
        this.toDate()?.parseToSimplifiedString()
    }
}

fun String.color(): Color {
    return Color(
        android.graphics.Color.parseColor(this)
    )
}


@RequiresApi(Build.VERSION_CODES.O)
fun String.toLocalDateTime(): LocalDateTime? {
    return LocalDateTime.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
}

fun String.toDate(): Date? {
    return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(this)
}