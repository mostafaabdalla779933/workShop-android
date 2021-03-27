package com.example.myapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.model.ArticlesItem


@Entity(tableName = "favourite")
data class FavouriteEntity (
    @PrimaryKey (autoGenerate = true)val articleId:Int ,
    @ColumnInfo val userId:String
)