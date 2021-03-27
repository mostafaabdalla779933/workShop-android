package com.example.myapplication.login

import com.example.myapplication.MyApplication
import com.example.myapplication.db.RoomAppDb
import com.example.myapplication.db.UserEntity
import com.example.myapplication.model.ArticlesItem
import com.example.myapplication.model.Response

class LocalDataSource:LocalDataSourceInterface {

    val userDao=RoomAppDb.getAppDatabase(MyApplication.getContext())?.DAO()


    override fun validateUser(userName: String,pass:String):Boolean {

        val user= userDao?.getUser(userName)

        if (user?.password.equals(pass)){

            return true
        }
        return false
    }

    override suspend fun cacheNews(response: Response) {
        TODO("Not yet implemented")
    }

    override suspend fun getNewsFromDB(): Response {
        TODO("Not yet implemented")
    }

    override suspend fun getFavorites(userID: Int): List<Response> {
        TODO("Not yet implemented")
    }

    override suspend fun addFavorite(article: ArticlesItem) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFavorite(article: ArticlesItem) {
        TODO("Not yet implemented")
    }


}