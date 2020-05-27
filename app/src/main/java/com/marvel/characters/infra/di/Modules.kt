package com.marvel.characters.infra.di

import com.marvel.characters.infra.api.config.ClientFactory
import com.marvel.characters.infra.api.config.RetrofitFactory
import com.marvel.characters.infra.api.config.RouteFactory
import com.marvel.characters.service.repository.external.character.CharacterService
import com.marvel.characters.service.repository.external.character.CharacterServiceImpl
import com.squareup.moshi.Moshi
import org.koin.dsl.module

val appModules = module {
    single { Moshi.Builder().build() }
    single { ClientFactory.build() }
    single { RetrofitFactory.build(get()) }
    single { RouteFactory.build<CharacterService>(get()) }
    factory { CharacterServiceImpl(get()) as CharacterService }
}