package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//CharacterDataWrapper {
//    code (int, optional): The HTTP status code of the returned result.,
//    status (string, optional): A string description of the call status.,
//    copyright (string, optional): The copyright notice for the returned result.,
//    attributionText (string, optional): The attribution notice for this result. Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.,
//    attributionHTML (string, optional): An HTML representation of the attribution notice for this result. Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API.,
//    data (CharacterDataContainer, optional): The results returned by the call.,
//    etag (string, optional): A digest value of the content returned by the call.
//}

@Parcelize
data class CharacterDataWrapper(
    @field: Json(name = "code") val code: Int? = null,
    @field: Json(name = "status") val status: String? = null,
    @field: Json(name = "copyright") val copyright: String? = null,
    @field: Json(name = "attributionText") val attributionText: String? = null,
    @field: Json(name = "attributionHTML") val attributionHTML: String? = null,
    @field: Json(name = "data") val data: CharacterDataContainer? = null,
    @field: Json(name = "etag") val etag: String? = null
): Parcelable