package com.mycompany.nbcapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Page(
    @SerializedName("page")
    val page: String,
    @SerializedName("shelves")
    val shelves: List<Shelve>
): Parcelable