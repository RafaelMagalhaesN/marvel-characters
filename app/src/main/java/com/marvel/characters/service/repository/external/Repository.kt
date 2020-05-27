package com.marvel.characters.service.repository.external

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class Repository : CoroutineScope {

    private val job: Job = Job()

    override val coroutineContext: CoroutineContext = Dispatchers.Default + job
}