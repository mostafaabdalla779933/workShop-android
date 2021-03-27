package com.example.myapplication.News

import com.example.myapplication.MyApplication
import com.example.myapplication.db.FavouriteEntity
import com.example.myapplication.db.RoomAppDb

class FavouriteDataSource:FavouriteLocalDataSourceInterface {
    val favouriteDao = RoomAppDb.getAppDatabase(MyApplication.getContext())?.DAO()
    override fun getUserFavourites(useremail: String): FavouriteEntity? {
        return favouriteDao?.getUserFavourites(useremail)
    }

    override fun insertFavourite(fav: FavouriteEntity): Boolean? {
       return favouriteDao?.insertFavourite(fav)?.let {
           it>0
       }
    }

    override fun deleteFavourite(fav: FavouriteEntity): Boolean? {
            return favouriteDao?.deleteFavourite(fav)?.let {
                it>0
            }
    }

}