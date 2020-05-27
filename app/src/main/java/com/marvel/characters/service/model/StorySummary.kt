package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//StorySummary {
//    resourceURI (string, optional): The path to the individual story resource.,
//    name (string, optional): The canonical name of the story.,
//    type (string, optional): The type of the story (interior or cover).
//}

@Parcelize
data class StorySummary(
    @field: Json(name = "resourceURI") val resourceURI: String? = null,
    @field: Json(name = "name") val name: String? = null,
    @field: Json(name = "type") val type: String? = null
): Parcelable