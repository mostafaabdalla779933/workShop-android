package com.example.myapplication.News

import com.example.myapplication.db.FavouriteEntity

class FavouriteRepo(var favouriteLocalDataSourceInterface: FavouriteLocalDataSourceInterface){

     fun getUserFavourites(useremail: String): FavouriteEntity? {
        return favouriteLocalDataSourceInterface.getUserFavourites(useremail)
    }

     fun insertFavourite(fav: FavouriteEntity): Boolean? {
        return favouriteLocalDataSourceInterface.insertFavourite(fav)
    }

     fun deleteFavourite(fav: FavouriteEntity) {
         favouriteLocalDataSourceInterface.deleteFavourite(fav)
    }


}