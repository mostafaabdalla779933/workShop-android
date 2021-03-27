package com.example.myapplication.login

import com.example.myapplication.db.UserEntity

interface LocalDataSourceInterface {

    fun validateUser(userName:String,password:String):Boolean


}