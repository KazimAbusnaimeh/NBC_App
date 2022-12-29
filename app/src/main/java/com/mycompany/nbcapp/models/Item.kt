package com.mycompany.nbcapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val image: String,
    val labelBadge: String?,
    val subtitle: String?,
    val tagline: String?,
    val title: String,
    val type: String
):Parcelable