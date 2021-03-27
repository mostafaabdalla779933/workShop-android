package com.example.myapplication.login

import com.example.myapplication.db.UserEntity

import com.example.myapplication.model.ArticlesItem
import com.example.myapplication.model.Response

interface LocalDataSourceInterface {

    fun validateUser(userName:String,password:String):Boolean

    suspend fun cacheNews(response: Response)

    suspend fun getNewsFromDB(): Response

    suspend fun getFavorites(userID: Int): List<Response>

    suspend fun addFavorite(article: ArticlesItem)

    suspend fun deleteFavorite(article: ArticlesItem)
}