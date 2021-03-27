package com.example.myapplication.repo

import com.example.myapplication.login.LocalDataSourceInterface
import com.example.myapplication.model.ArticlesItem
import com.example.myapplication.model.Response

class NewsRepo(
    private val remoteDataSourceInterface: RemoteDataSourceInterface,
    private val localDataSourceInterface: LocalDataSourceInterface
) : NewsRepoInterface {

    override suspend fun getFreshNews(topic: String): Response =
        remoteDataSourceInterface.getNews(topic)

    override suspend fun cacheNews(response: Response) =
        localDataSourceInterface.cacheNews(response)


    override suspend fun getNewsFromDB(): Response =
        localDataSourceInterface.getNewsFromDB()


    override suspend fun getFavorites(userID: Int): List<Response> =
        localDataSourceInterface.getFavorites(userID)


    override suspend fun addFavorite(article: ArticlesItem) {
        localDataSourceInterface.addFavorite(article)
    }

    override suspend fun deleteFavorite(article: ArticlesItem) {
        localDataSourceInterface.deleteFavorite(article)
    }

}