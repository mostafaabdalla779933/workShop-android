package com.example.myapplication.login

interface LoginRepoInterface{

    fun validateUser(userName: String, pass: String):Boolean

    suspend fun getEmails():List<String>?


}