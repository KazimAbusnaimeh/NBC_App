package com.mycompany.nbcapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mycompany.nbcapp.datasource.Api
import com.mycompany.nbcapp.repository.Repository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.Headers
import okhttp3.internal.addHeaderLenient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object Modules {

    @Provides
    fun provideGson():Moshi{
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }
}