package com.lucas.marvellist.utils.extensions

fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }
