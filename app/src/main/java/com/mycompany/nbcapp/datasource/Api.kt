package com.mycompany.nbcapp.datasource

import android.content.Context
import com.mycompany.nbcapp.R
import com.mycompany.nbcapp.models.Page
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class Api @Inject constructor(
    @ApplicationContext private val context: Context,
    private val moshi: Moshi
) {
    fun getPage(): Page {
        val json =
            context.resources.openRawResource(R.raw.home).bufferedReader().use { it.readText() }
        return moshi.adapter(Page::class.java).fromJson(json)!!
    }
}