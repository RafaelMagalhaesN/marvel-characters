package com.marvel.characters

import android.app.Application
import com.marvel.characters.infra.di.appModules
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startDI()
    }

    private fun startDI() = startKoin {
        appModules
    }
}