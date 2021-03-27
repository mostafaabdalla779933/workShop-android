package com.example.myapplication.login

import com.example.myapplication.db.UserEntity

class LoginRepo(var localDataSourceInterface: LocalDataSourceInterface){



    fun validateUser(userName: String, pass: String):Boolean {
      return  localDataSourceInterface.validateUser(userName,pass)
    }



}