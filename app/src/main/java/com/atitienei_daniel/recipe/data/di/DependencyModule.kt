package com.atitienei_daniel.recipe.data.di

import com.atitienei_daniel.recipe.data.remote.SpoonacularApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependencyModule {

    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providesSpoonacularApi(moshi: Moshi): SpoonacularApi = Retrofit.Builder()
        .baseUrl(SpoonacularApi.url)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(SpoonacularApi::class.java)
}