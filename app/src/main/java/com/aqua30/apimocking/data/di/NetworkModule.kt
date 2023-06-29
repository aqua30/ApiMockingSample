package com.aqua30.apimocking.data.di

import com.aqua30.apimocking.data.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author saurabh
 */
@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://official-joke-api.appspot.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
}