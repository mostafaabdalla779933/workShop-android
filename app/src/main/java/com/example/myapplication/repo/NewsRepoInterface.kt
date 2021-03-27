package com.example.myapplication.repo

import com.example.myapplication.model.ArticlesItem
import com.example.myapplication.model.Response

interface NewsRepoInterface {

    suspend fun getFreshNews(topic: String): Response

    suspend fun cacheNews(response: Response)

    suspend fun getNewsFromDB(): Response

    suspend fun getFavorites(userID: Int): List<Response>

    suspend fun addFavorite(article: ArticlesItem)

    suspend fun deleteFavorite(article: ArticlesItem)

}