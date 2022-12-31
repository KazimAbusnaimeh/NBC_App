package com.mycompany.nbcapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import javax.inject.Singleton

@Parcelize
@JsonClass(generateAdapter = true)
data class Page(
    @Json(name = "page")
    val page: String,
    @Json(name = "shelves")
    val shelves: List<Shelve>
) : Parcelable