package com.mycompany.nbcapp.repository

import com.mycompany.nbcapp.datasource.Api
import com.mycompany.nbcapp.models.Page
import retrofit2.Call
import javax.inject.Inject

class Repository @Inject constructor(private val api: Api) {

    suspend fun getPage(): Call<Page> {
        return api.getPage()
    }
}