package com.example.myapplication.login

import android.content.SharedPreferences
import com.example.myapplication.db.UserEntity

class LoginRepo(var localDataSourceInterface: LocalDataSourceInterface,var sharedPreferences: SharedPreferences){
    lateinit var editor: SharedPreferences.Editor

    fun validateUser(userName: String, pass: String):Boolean {
      return  localDataSourceInterface.validateUser(userName,pass)
    }

    fun SetUserId(useremail: String){
        editor=sharedPreferences.edit()
        editor.putString("UserID",useremail)
        editor.apply()
    }


}