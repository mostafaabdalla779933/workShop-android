package com.example.myapplication.repo


class RemoteDataSourceImpl : RemoteDataSourceInterface {

    suspend override fun getNews(topic: String) = ApiServiceInterface.create().getNews(topic)

}