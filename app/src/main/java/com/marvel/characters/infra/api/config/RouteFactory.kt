package com.marvel.characters.infra.api.config

import retrofit2.Retrofit

object RouteFactory {

    /// Create new route
    inline fun <reified T> build(retrofit: Retrofit): T = retrofit.create(T::class.java)
}