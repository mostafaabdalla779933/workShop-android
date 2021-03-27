package com.example.myapplication.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.login.LoginRepo

class LoginViewModel(val loginRepo: LoginRepo):ViewModel() {



    fun validateUser(user:String,pass:String):Boolean{


       return loginRepo.validateUser(user,pass)

    }


}