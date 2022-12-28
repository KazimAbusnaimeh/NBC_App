package com.mycompany.nbcapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shelve(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
): Parcelable