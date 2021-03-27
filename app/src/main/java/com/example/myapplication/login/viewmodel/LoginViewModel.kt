package com.example.myapplication.login.viewmodel

import androidx.lifecycle.ViewModel

import com.example.myapplication.login.LoginRepoInterface

class LoginViewModel(val loginRepo: LoginRepoInterface):ViewModel() {



    fun validateUser(user:String,pass:String):Boolean{


       return loginRepo.validateUser(user,pass)

    }


}