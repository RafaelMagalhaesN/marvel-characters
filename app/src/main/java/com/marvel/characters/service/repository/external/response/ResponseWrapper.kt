package com.marvel.characters.service.repository.external.response

sealed class ResponseWrapper<out T> {

    data class Success<out T>(val value: T): ResponseWrapper<T>()

    data class Error(val code: Int? = null): ResponseWrapper<Nothing>()

    object NetworkError: ResponseWrapper<Nothing>()
}