package com.example.myapplication.repo

import com.example.myapplication.model.Response

interface RemoteDataSourceInterface {
    suspend fun getNews(topic: String): Response
}