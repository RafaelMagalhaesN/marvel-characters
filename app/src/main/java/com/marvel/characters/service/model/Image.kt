package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//Image {
//    path (string, optional): The directory path of to the image.,
//    extension (string, optional): The file extension for the image.
//}

@Parcelize
data class Image(
    @field: Json(name = "path") val path: String? = null,
    @field: Json(name = "extension") val extension: String? = null
): Parcelable