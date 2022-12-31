package com.mycompany.nbcapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "image")
    val image: String,
    @Json(name = "labelBadge")
    val labelBadge: String?,
    @Json(name = "subtitle")
    val subtitle: String?,
    @Json(name = "tagline")
    val tagline: String?,
    @Json(name = "title")
    val title: String,
    @Json(name = "type")
    val type: String
) : Parcelable