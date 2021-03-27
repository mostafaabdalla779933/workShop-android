package com.example.myapplication.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.login.LoginRepo

class LoginViewModelFactory(val loginRepo: LoginRepo) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return LoginViewModel(loginRepo) as T
    }
}