package com.example.myapplication.Registration.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Registration.RegistrationRepo
import com.example.myapplication.db.UserEntity
import com.example.myapplication.login.LoginRepo

class RegistrationViewModel(val registrationRepo: RegistrationRepo): ViewModel() {

    fun insertUser(user: UserEntity){
        registrationRepo.insertUser(user)
    }

}