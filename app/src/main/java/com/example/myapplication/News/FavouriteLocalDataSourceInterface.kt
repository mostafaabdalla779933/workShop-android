package com.example.myapplication.News

import com.example.myapplication.db.FavouriteEntity

interface FavouriteLocalDataSourceInterface {
    fun getUserFavourites(useremail: String): FavouriteEntity?

    fun insertFavourite(fav: FavouriteEntity): Boolean?

    fun deleteFavourite(fav: FavouriteEntity): Boolean?
}