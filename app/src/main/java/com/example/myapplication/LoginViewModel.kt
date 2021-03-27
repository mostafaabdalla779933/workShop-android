package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.db.RoomAppDb
import com.example.myapplication.db.UserEntity

class LoginViewModel(app: Application): AndroidViewModel(app) {
    lateinit var allUsers : MutableLiveData<List<UserEntity>>

    init{
        allUsers = MutableLiveData()
        getallUsers()
    }

    fun getAllUsersObservers(): MutableLiveData<List<UserEntity>> {
        return allUsers
    }

    fun getallUsers() {
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.DAO()
        val list = userDao?.getAllUsers()

        allUsers.postValue(list)
    }

    fun insertUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.DAO()
        userDao?.insertUser(entity)
        getallUsers()
    }


    fun deleteUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.DAO()
        userDao?.deleteUser(entity)
        getallUsers()
    }
    fun getUserInfo(email: String){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.DAO()
        userDao?.getUser(email = email)
        getallUsers()
    }
}