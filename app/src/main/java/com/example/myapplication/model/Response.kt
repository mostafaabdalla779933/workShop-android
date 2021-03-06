package com.example.myapplication.model

import com.example.myapplication.ArticlesItem
import com.google.gson.annotations.SerializedName

data class Response(

    @field:SerializedName("totalResults")
    val totalResults: Int? = null,

    @field:SerializedName("articles")
    val articles: List<ArticlesItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null
)