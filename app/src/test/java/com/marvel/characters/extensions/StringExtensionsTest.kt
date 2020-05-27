package com.marvel.characters.extensions


import com.marvel.characters.infra.extensions.md5
import com.marvel.characters.service.repository.external.response.ResponseWrapper
import com.marvel.characters.service.repository.external.response.callAPI
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class StringExtensionsTest {

    @ExperimentalCoroutinesApi
    @Test
    fun `test md5 parsing`() {
        val value: String = "Test"
        val md5Hashing: String = "0cbc6611f5540bd0809a388dc95a615b"

        Assert.assertEquals(value.md5(), md5Hashing)
    }
}