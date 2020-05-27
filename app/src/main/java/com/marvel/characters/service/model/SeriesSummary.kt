package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//SeriesSummary {
//    resourceURI (string, optional): The path to the individual series resource.,
//    name (string, optional): The canonical name of the series.
//}

@Parcelize
data class SeriesSummary(
    @field: Json(name = "resourceURI") val resourceURI: String? = null,
    @field: Json(name = "name") val name: String? = null
): Parcelable