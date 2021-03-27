package com.example.myapplication.Registration

import com.example.myapplication.db.UserEntity

class RegistrationRepo(var localDataSourceInterface: LocalDataSourceInterface){

    fun insertUser(user: UserEntity){
        localDataSourceInterface.insertUser(user)
    }


}