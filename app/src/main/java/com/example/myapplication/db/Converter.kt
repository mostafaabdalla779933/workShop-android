package com.example.myapplication.db

import androidx.room.TypeConverter
import com.example.myapplication.model.ArticlesItem
import com.google.gson.Gson

class Converter {
    @TypeConverter
    fun fromListtoGson(articlesitem: List<ArticlesItem?>?): String? {
        return Gson().toJson(articlesitem)
    }

    @TypeConverter
    fun fromGsontoList(articles: String?): List<String?>? {
        return Gson().fromJson<List<*>>(articles, MutableList::class.java) as List<String?>?
    }
}