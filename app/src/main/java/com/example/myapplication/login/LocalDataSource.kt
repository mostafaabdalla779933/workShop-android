package com.example.myapplication.login

import com.example.myapplication.MyApplication
import com.example.myapplication.db.RoomAppDb

class LocalDataSource:LocalDataSourceInterface {

    val userDao=RoomAppDb.getAppDatabase(MyApplication.getContext())?.DAO()


    override fun validateUser(userName: String,pass:String):Boolean {

        val user= userDao?.getUser(userName)

        if (user?.password.equals(pass)){

            return true
        }
        return false
    }


}