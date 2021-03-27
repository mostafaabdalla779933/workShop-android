package com.example.myapplication.News

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.db.FavouriteEntity
import com.example.myapplication.login.LocalDataSource
import com.example.myapplication.model.Response
import com.example.myapplication.repo.NewsRepo
import com.example.myapplication.repo.RemoteDataSourceImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NewsViewModel(val favouriteRepo: FavouriteRepo) : ViewModel() {

    val newsRepo: NewsRepo = NewsRepo(RemoteDataSourceImpl(), LocalDataSource())
    val newsData: MutableLiveData<Response> = MutableLiveData()

    fun fetchNews(topic: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = newsRepo.getFreshNews(topic)
            newsData.postValue(response)
        }
    }
    fun getUserFavourites(useremail: String): FavouriteEntity? {
        return favouriteRepo.getUserFavourites(useremail)
    }

    fun insertFavourite(fav: FavouriteEntity): Boolean? {
        return favouriteRepo.insertFavourite(fav)
    }

    fun deleteFavourite(fav: FavouriteEntity): Boolean? {
        return favouriteRepo.deleteFavourite(fav)
    }
}