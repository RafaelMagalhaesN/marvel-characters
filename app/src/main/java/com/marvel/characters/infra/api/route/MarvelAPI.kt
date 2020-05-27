package com.marvel.characters.infra.api.route

import com.marvel.characters.infra.api.env.Parameter
import com.marvel.characters.infra.api.env.Path
import com.marvel.characters.service.model.CharacterDataWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {

    /**
     * @description Fetches lists of comic characters with optional filters.
     * @see <a href="https://developer.marvel.com/docs#!/public/getCreatorCollection_get_0">
     *     Marvel Docs </a>
     */
    @GET(Path.characters)
    suspend fun getCharacters(
        @Query(Parameter.apiKey) apiKey: String,
        @Query(Parameter.hash) hash: String,
        @Query(Parameter.ts) timestamp: String
    ): Response<CharacterDataWrapper>

}