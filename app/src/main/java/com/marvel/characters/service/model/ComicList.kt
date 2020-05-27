package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//ComicList {
//    available (int, optional): The number of total available issues in this list. Will always be greater than or equal to the "returned" value.,
//    returned (int, optional): The number of issues returned in this collection (up to 20).,
//    collectionURI (string, optional): The path to the full list of issues in this collection.,
//    items (Array[ComicSummary], optional): The list of returned issues in this collection.
//}

@Parcelize
data class ComicList(
    @field: Json(name = "available") val resourceURI: Int? = null,
    @field: Json(name = "returned") val returned: String? = null,
    @field: Json(name = "collectionURI") val collectionURI: String? = null,
    @field: Json(name = "items") val items: List<ComicSummary?>? = null
): Parcelable