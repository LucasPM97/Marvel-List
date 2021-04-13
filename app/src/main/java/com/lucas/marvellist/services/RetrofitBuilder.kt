package com.lucas.marvellist.services

import com.lucas.marvellist.utils.extensions.md5
import com.lucas.marvellist.utils.extensions.toHex
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                        createMarvelApiClient()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build() //Doesn't require the adapter
    }

    val heroService: HeroService = getRetrofit().create(HeroService::class.java)
}