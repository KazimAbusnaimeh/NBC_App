package com.mycompany.nbcapp.repository

import com.mycompany.nbcapp.datasource.Api
import com.mycompany.nbcapp.models.Page
import javax.inject.Inject

class Repository @Inject constructor(private val api: Api) {

    fun getPage(): Page {
        return api.getPage()
    }
}