package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//Url {
//    type (string, optional): A text identifier for the URL.,
//    url (string, optional): A full URL (including scheme, domain, and path).
//}

@Parcelize
data class Url(
    @field: Json(name = "url") val url: String? = null,
    @field: Json(name = "type") val type: String? = null
): Parcelable