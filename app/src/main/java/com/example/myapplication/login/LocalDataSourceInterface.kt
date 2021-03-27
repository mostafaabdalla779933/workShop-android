package com.example.myapplication.login

import com.example.myapplication.MyApplication
import com.example.myapplication.db.RoomAppDb

interface LocalDataSourceInterface {

    fun validateUser(userName:String,password:String):Boolean


}