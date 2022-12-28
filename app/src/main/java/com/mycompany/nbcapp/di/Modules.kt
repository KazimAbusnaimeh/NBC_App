package com.mycompany.nbcapp.di

import com.google.gson.GsonBuilder
import com.mycompany.nbcapp.datasource.Api
import com.mycompany.nbcapp.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object Modules {

    @Provides
     fun provideApi(): Api {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://s3.us-west-2.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Api::class.java)
    }
}