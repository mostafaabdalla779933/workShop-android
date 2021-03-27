package com.example.myapplication.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.myapplication.login.LoginRepoInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(val loginRepo: LoginRepoInterface):ViewModel() {



    var emailsLiveData=MutableLiveData<List<String>?>()

    fun getEmails(){

        CoroutineScope(Dispatchers.IO).launch {

            var arr=loginRepo.getEmails()
            emailsLiveData.postValue(arr)

        }


    }

    fun validateUser(user:String,pass:String):Boolean{


       return loginRepo.validateUser(user,pass)

    }


}