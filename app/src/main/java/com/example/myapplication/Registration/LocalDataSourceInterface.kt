package com.example.myapplication.Registration

import com.example.myapplication.db.UserEntity

interface LocalDataSourceInterface {
    fun insertUser(user: UserEntity)
}