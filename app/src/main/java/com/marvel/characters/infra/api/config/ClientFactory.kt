package com.marvel.characters.infra.api.config

import okhttp3.OkHttpClient

object ClientFactory {

    fun build(): OkHttpClient = OkHttpClient.Builder()
        .followRedirects(true)
        .followSslRedirects(true)
        .build()

}