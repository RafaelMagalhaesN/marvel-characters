package com.marvel.characters.service.repository.external.character

import com.marvel.characters.service.model.CharacterDataWrapper
import com.marvel.characters.service.repository.external.response.ResponseWrapper

interface CharacterRepository {

    /// Provide all marvel characters
    suspend fun getCharacters(): ResponseWrapper<CharacterDataWrapper>
}