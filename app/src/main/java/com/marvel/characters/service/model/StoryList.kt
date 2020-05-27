package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//StoryList {
//    available (int, optional): The number of total available stories in this list. Will always be greater than or equal to the "returned" value.,
//    returned (int, optional): The number of stories returned in this collection (up to 20).,
//    collectionURI (string, optional): The path to the full list of stories in this collection.,
//    items (Array[StorySummary], optional): The list of returned stories in this collection.
//}

@Parcelize
data class StoryList(
    @field: Json(name = "available") val resourceURI: Int? = null,
    @field: Json(name = "returned") val returned: String? = null,
    @field: Json(name = "collectionURI") val collectionURI: String? = null,
    @field: Json(name = "items") val items: List<StorySummary?>? = null
): Parcelable