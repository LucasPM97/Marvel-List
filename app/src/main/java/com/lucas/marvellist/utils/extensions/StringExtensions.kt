package com.lucas.marvellist.utils.extensions

import java.security.MessageDigest

fun String.md5(): ByteArray = MessageDigest.getInstance("MD5").digest(this.toByteArray(Charsets.UTF_8))

fun String.formatHttpUrlToHttps(): String {
    return this.replace("http", "https")
}