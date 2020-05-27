package com.marvel.characters.service.repository.external.response

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> callAPI(dispatcher: CoroutineDispatcher, api: () -> T): ResponseWrapper<T> =
    withContext(dispatcher) {
        try {
            ResponseWrapper.Success(api.invoke())
        } catch (ioException: IOException) {
            ResponseWrapper.NetworkError
        } catch (httpException: HttpException) {
            ResponseWrapper.Error(httpException.code())
        } catch (genericException: Exception) {
            ResponseWrapper.Error(0)
        }
}
