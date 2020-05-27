package com.marvel.characters.mock

import java.io.InputStreamReader

object MockJSONReader {

    fun read(path: String): String {
        val input = InputStreamReader(javaClass.classLoader!!.getResourceAsStream(path))
        val fileParsedToString: String = input.readText()
        input.close()
        return fileParsedToString
    }
}