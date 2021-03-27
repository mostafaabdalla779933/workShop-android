package com.example.myapplication.login


class LoginRepo(var localDataSourceInterface: LocalDataSourceInterface) : LoginRepoInterface {




    override fun validateUser(userName: String, pass: String):Boolean {
      return  localDataSourceInterface.validateUser(userName,pass)
    }

    override suspend fun getEmails(): List<String>? {

        return localDataSourceInterface.getEmails()
    }


}