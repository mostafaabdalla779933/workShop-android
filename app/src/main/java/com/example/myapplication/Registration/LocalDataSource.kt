package com.example.myapplication.Registration

import com.example.myapplication.MyApplication
import com.example.myapplication.db.RoomAppDb
import com.example.myapplication.db.UserEntity

class LocalDataSource :
    LocalDataSourceInterface {
    val userDao= RoomAppDb.getAppDatabase(MyApplication.getContext())?.DAO()

    override fun insertUser(user: UserEntity) {
        userDao?.insertUser(user)
    }
}