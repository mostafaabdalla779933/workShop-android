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
        fun insertUser(userEntity: UserEntity?):Long

        @Delete
        fun deleteUser(userEntity: UserEntity?)

        @Query("SELECT * FROM Users where Email= :email")
        fun getUser( email:String): UserEntity
    }
