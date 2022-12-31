package com.mycompany.nbcapp.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object Modules {

    @Provides
    fun provideGson(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }
}