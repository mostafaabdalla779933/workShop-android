package com.example.myapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UserEntity (
    @PrimaryKey val Email: String,
    @ColumnInfo val password:String
)