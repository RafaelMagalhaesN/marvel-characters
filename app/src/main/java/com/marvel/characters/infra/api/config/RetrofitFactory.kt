package com.marvel.characters.infra.api.config

import com.marvel.characters.infra.api.env.Environment
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {

    fun build(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Environment.baseEndpoint)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .build()
}