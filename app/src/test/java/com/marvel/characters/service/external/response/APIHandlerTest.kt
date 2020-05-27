package com.marvel.characters.service.external.response

import com.marvel.characters.service.repository.external.response.ResponseWrapper
import com.marvel.characters.service.repository.external.response.callAPI
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class APIHandlerTest {

    @ExperimentalCoroutinesApi
    private val testCoroutineDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Test
    fun `test when api handler wrapper success response`() {
        runBlockingTest {
            val successResponse: Boolean = true
            val httpResponse = callAPI(testCoroutineDispatcher) {
                successResponse
            }

            assertEquals(ResponseWrapper.Success(successResponse), httpResponse)
        }
    }
}