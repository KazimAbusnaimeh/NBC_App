package com.mycompany.nbcapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    @SerializedName("image")
    val image: String,
    @SerializedName("labelBadge")
    val labelBadge: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
):Parcelable