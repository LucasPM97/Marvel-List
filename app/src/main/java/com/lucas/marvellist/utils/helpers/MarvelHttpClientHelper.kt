package com.lucas.marvellist.services

import com.lucas.marvellist.utils.ApiConsts
import com.lucas.marvellist.utils.extensions.md5
import com.lucas.marvellist.utils.extensions.toHex
import okhttp3.HttpUrl
import okhttp3.OkHttpClient

fun createMarvelApiClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .addMarvelInterceptor()
            .build()
}

private fun OkHttpClient.Builder.addMarvelInterceptor(): OkHttpClient.Builder {
    return this.addInterceptor { chain ->
        val originalRequest = chain.request()
        val httpUrl = originalRequest.url()

        val newHttpUrl = addMarvelApiQueryParameters(httpUrl)
        println(newHttpUrl.url())
        val request = originalRequest.newBuilder()
                .url(newHttpUrl)
                .build()
        chain.proceed(request)
    }
}

private fun addMarvelApiQueryParameters(httpUrl: HttpUrl): HttpUrl {
    return httpUrl.newBuilder()
            .addQueryParameter("apikey", ApiConsts.PublicApiKey)
            .addQueryParameter("ts", "1")
            .addQueryParameter(
                    "hash",
                    "1${ApiConsts.PrivateApiKey}${ApiConsts.PublicApiKey}"
                            .md5()
                            .toHex()
            )
            .build()
}
