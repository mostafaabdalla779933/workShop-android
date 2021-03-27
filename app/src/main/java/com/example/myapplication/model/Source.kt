package com.example.myapplication.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Source(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: String? = null
)