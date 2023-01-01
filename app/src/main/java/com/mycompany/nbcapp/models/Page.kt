package com.mycompany.nbcapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Page(
    @Json(name = "page")
    val page: String,
    @Json(name = "shelves")
    val shelves: List<Shelve>
) : Parcelable