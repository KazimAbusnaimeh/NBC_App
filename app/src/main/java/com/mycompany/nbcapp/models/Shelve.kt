package com.mycompany.nbcapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Shelve(
    @Json(name = "items")
    val items: List<Item>,
    @Json(name = "title")
    val title: String,
    @Json(name = "type")
    val type: String
): Parcelable