package com.lucas.marvellist.utils.extensions

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun Date.parseToSimplifiedString(): String {
    return SimpleDateFormat("dd 'de' MMMM yyyy").format(this)
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDateTime.parseToSimplifiedString(): String {
    val formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM yyyy")
    return format(formatter)
}

