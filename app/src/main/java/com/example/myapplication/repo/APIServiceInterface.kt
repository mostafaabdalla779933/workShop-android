package com.example.myapplication.repo

import com.example.myapplication.model.Response
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val key = "e3cc55767dd0423c8753809d054153c0"

interface ApiServiceInterface {
    @GET("everything")
    suspend fun getNews(
        @Query("q") topic: String,
        @Query("apiKey") apiKey: String = key
    ): Response

    companion object {
        fun create(): ApiServiceInterface {
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(ApiServiceInterface::class.java)
        }
    }

}
