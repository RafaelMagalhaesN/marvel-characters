package com.marvel.characters.service.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//Character {
//    id (int, optional): The unique ID of the character resource.,
//    name (string, optional): The name of the character.,
//    description (string, optional): A short bio or description of the character.,
//    modified (Date, optional): The date the resource was most recently modified.,
//    resourceURI (string, optional): The canonical URL identifier for this resource.,
//    urls (Array[Url], optional): A set of public web site URLs for the resource.,
//    thumbnail (Image, optional): The representative image for this character.,
//    comics (ComicList, optional): A resource list containing comics which feature this character.,
//    stories (StoryList, optional): A resource list of stories in which this character appears.,
//    events (EventList, optional): A resource list of events in which this character appears.,
//    series (SeriesList, optional): A resource list of series in which this character appears.
//}

@Parcelize
data class Character(
    @field: Json(name = "id") val id: Int? = null,
    @field: Json(name = "name") val name: String? = null,
    @field: Json(name = "description") val description: String? = null,
    @field: Json(name = "modified") val modified: String? = null,
    @field: Json(name = "resourceURI") val resourceURI: String? = null,
    @field: Json(name = "urls") val urls: List<Url?>? = null,
    @field: Json(name = "thumbnail") val thumbnail: Image? = null,
    @field: Json(name = "comics") val comics: ComicList? = null,
    @field: Json(name = "stories") val stories: StoryList? = null,
    @field: Json(name = "events") val events: EventList? = null,
    @field: Json(name = "series") val series: SeriesList? = null
): Parcelable