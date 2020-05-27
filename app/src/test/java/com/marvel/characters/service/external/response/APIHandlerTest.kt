package com.marvel.characters.service.external.response

import com.marvel.characters.service.repository.external.response.ResponseWrapper
import com.marvel.characters.service.repository.external.response.callAPI
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class APIHandlerTest {

    @ExperimentalCoroutinesApi
    private val testCoroutineDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Test
    fun `test when api handler success response`() {
        runBlockingTest {
            val successResponse: Boolean = true
            val httpResponse = callAPI(testCoroutineDispatcher) {
                successResponse
            }

            assertEquals(ResponseWrapper.Success(successResponse), httpResponse)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test when api handler has IOException`() {
        runBlockingTest {
            val httpResponse = callAPI(testCoroutineDispatcher) {
                throw IOException()
            }

            assertEquals(ResponseWrapper.NetworkError, httpResponse)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test when api handler has HttpException`() {
        runBlockingTest {
            val httpResponse = callAPI(testCoroutineDispatcher) {
                throw HttpException(Response.error<Any>(404, ResponseBody.create(
                    MediaType.get("application/json"),
                    "{}"
                )))
            }

            assertEquals(ResponseWrapper.Error(code = 404), httpResponse)
            assertEquals(404, (httpResponse as ResponseWrapper.Error).code)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `test when api handler has Exception`() {
        runBlockingTest {
            val httpResponse = callAPI(testCoroutineDispatcher) {
                throw Exception()
            }

            assertEquals(ResponseWrapper.Error(code = 0), httpResponse)
        }
    }
}