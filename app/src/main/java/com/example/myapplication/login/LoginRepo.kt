package com.example.myapplication.login

class LoginRepo(var localDataSourceInterface: LocalDataSourceInterface){



    fun validateUser(userName: String, pass: String):Boolean {
      return  localDataSourceInterface.validateUser(userName,pass)
    }


}