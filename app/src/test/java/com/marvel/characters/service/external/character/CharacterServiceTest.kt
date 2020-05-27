package com.marvel.characters.service.external.character

import com.marvel.characters.infra.api.config.ClientFactory
import com.marvel.characters.infra.api.config.RetrofitFactory
import com.marvel.characters.infra.api.config.RouteFactory
import com.marvel.characters.infra.api.route.CharacterRoute
import com.marvel.characters.mock.MockJSONReader
import com.marvel.characters.service.model.CharacterDataWrapper
import com.marvel.characters.service.repository.external.character.CharacterService
import com.marvel.characters.service.repository.external.character.CharacterServiceImpl
import com.marvel.characters.service.repository.external.response.ResponseWrapper
import com.squareup.moshi.Moshi
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.withContext
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.get
import java.net.HttpURLConnection

class CharacterServiceTest : KoinTest {

    @ExperimentalCoroutinesApi
    private val testCoroutineDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        startKoin {
            androidLogger(Level.DEBUG)
            // Load modules
            modules((listOf(
                module {
                    single { MockWebServer() }
                    single { Moshi.Builder().build() }
                    single { ClientFactory.build() }
                    single { RetrofitFactory.build(get(),
                        baseUrl = get<MockWebServer>().url("/").toString()) }
                    factory { RouteFactory.build<CharacterRoute>(get()) }
                    factory { CharacterServiceImpl(get()) as CharacterService }
                }
            )))
        }
    }

    @After
    fun after() {
        get<MockWebServer>().shutdown()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test when characters is received with proper body`() {
        val mockedResponse: MockResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockJSONReader.read("characters_mocked.json"))

        get<MockWebServer>().enqueue(mockedResponse)

        val service: CharacterService = get()
        runBlocking {
            withContext(testCoroutineDispatcher) {
                val responseWrapper: ResponseWrapper<CharacterDataWrapper?> = service.getCharacters()
                assertTrue(responseWrapper is ResponseWrapper.Success)

                val data = (responseWrapper as ResponseWrapper.Success).value
                assertEquals(data?.code, 200)
                assertEquals(data?.status, "Ok")
            }
        }
    }
}