package com.example.myapplication.Registration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Registration.RegistrationRepo
import com.example.myapplication.login.viewmodel.LoginViewModel

class RegistrationViewModelFactory(val registrationRepo: RegistrationRepo) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return RegistrationViewModel(registrationRepo) as T
    }
}