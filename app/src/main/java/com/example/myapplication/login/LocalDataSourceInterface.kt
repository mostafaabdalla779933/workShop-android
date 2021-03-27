package com.example.myapplication.login

interface LocalDataSourceInterface {

    fun validateUser(userName:String,password:String):Boolean

}