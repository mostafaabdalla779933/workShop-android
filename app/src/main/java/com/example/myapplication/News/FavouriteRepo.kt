package com.example.myapplication.News

import com.example.myapplication.Registration.LocalDataSourceInterface
import com.example.myapplication.db.FavouriteEntity
import com.example.myapplication.db.UserEntity

class FavouriteRepo(var favouriteLocalDataSourceInterface: FavouriteLocalDataSourceInterface){

     fun getUserFavourites(useremail: String): FavouriteEntity? {
        return favouriteLocalDataSourceInterface.getUserFavourites(useremail)
    }

     fun insertFavourite(fav: FavouriteEntity): Boolean? {
        return favouriteLocalDataSourceInterface.insertFavourite(fav)
    }

     fun deleteFavourite(fav: FavouriteEntity): Boolean? {
        return favouriteLocalDataSourceInterface.deleteFavourite(fav)
    }


}