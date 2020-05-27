package com.marvel.characters.service.repository.external.character

import com.marvel.characters.infra.api.env.Environment
import com.marvel.characters.infra.api.route.CharacterRoute
import com.marvel.characters.infra.extensions.md5
import com.marvel.characters.service.model.CharacterDataWrapper
import com.marvel.characters.service.repository.external.Repository
import com.marvel.characters.service.repository.external.response.ResponseWrapper
import com.marvel.characters.service.repository.external.response.callAPI
import kotlinx.coroutines.Dispatchers
import java.util.*

class CharacterServiceImpl(private val service: CharacterRoute) :
    CharacterService,
    Repository() {

    override suspend fun getCharacters(): ResponseWrapper<CharacterDataWrapper?> =
        callAPI(Dispatchers.IO) {
            val timestamp: String = Date().time.toString()

            val hash: String = (timestamp +
                    Environment.privateAPIKey +
                    Environment.publicAPIKey).md5()

            service.getCharacters(apiKey = Environment.publicAPIKey,
                timestamp = timestamp,
                hash = hash).body()
        }
}