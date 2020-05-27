package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//CharacterDataContainer {
//    offset (int, optional): The requested offset (number of skipped results) of the call.,
//    limit (int, optional): The requested result limit.,
//    total (int, optional): The total number of resources available given the current filter set.,
//    count (int, optional): The total number of results returned by this call.,
//    results (Array[Character], optional): The list of characters returned by the call.
//}

@Parcelize
data class CharacterDataContainer(
    @field: Json(name = "offset") val offset: Int? = null,
    @field: Json(name = "limit") val limit: Int? = null,
    @field: Json(name = "total") val total: Int? = null,
    @field: Json(name = "count") val count: Int? = null,
    @field: Json(name = "results") val results: List<Character?>? = null
): Parcelable