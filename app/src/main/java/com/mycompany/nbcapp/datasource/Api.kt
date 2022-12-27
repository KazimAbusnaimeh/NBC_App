package com.mycompany.nbcapp.datasource

import com.mycompany.nbcapp.models.Page
import com.mycompany.nbcapp.utils.Constants.PAGE_RESOURCE
import retrofit2.Call
import retrofit2.http.GET


interface Api {

    @GET(PAGE_RESOURCE)
    suspend fun getPage():Call<Page>
}