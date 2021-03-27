package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAO {
    @Query("SELECT * FROM Users ")
    fun getAllUsers(): List<UserEntity>?

    @Insert
    fun insertUser(userEntity: UserEntity?): Long

    @Delete
    fun deleteUser(userEntity: UserEntity?)

    @Query("SELECT * FROM Users where Email= :email")
    fun getUser(email: String): UserEntity

    @Query("SELECT * FROM news ")
    fun getAllNews(): List<NewsEntity>?

    @Query("SELECT * FROM favourite where userId= :useremail")
    fun getUserFavourites(useremail: String): FavouriteEntity?

    @Insert
    fun insertFavourite(fav: FavouriteEntity): Long?

    @Delete
    fun deleteFavourite(fav: FavouriteEntity): Long?
}
