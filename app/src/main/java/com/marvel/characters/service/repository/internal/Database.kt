package com.marvel.characters.service.repository.internal

import android.content.Context
import android.content.SharedPreferences

class Database(private val context: Context) {
    fun build(): SharedPreferences =
        context.getSharedPreferences(DatabaseProperties.databaseName, Context.MODE_PRIVATE)
}