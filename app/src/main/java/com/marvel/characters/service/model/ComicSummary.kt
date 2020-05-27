package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//ComicSummary {
//    resourceURI (string, optional): The path to the individual comic resource.,
//    name (string, optional): The canonical name of the comic.
//}

@Parcelize
data class ComicSummary(
    @field: Json(name = "resourceURI") val resourceURI: String? = null,
    @field: Json(name = "name") val name: String? = null
): Parcelable