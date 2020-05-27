package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//EventSummary {
//    resourceURI (string, optional): The path to the individual event resource.,
//    name (string, optional): The name of the event.
//}

@Parcelize
data class EventSummary(
    @field: Json(name = "resourceURI") val resourceURI: String? = null,
    @field: Json(name = "name") val name: String? = null
): Parcelable