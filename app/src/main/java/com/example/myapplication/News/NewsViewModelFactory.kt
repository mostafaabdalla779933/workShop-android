package com.example.myapplication.News

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.login.LocalDataSourceInterface
import com.example.myapplication.Registration.RegistrationRepo
import com.example.myapplication.Registration.viewmodel.RegistrationViewModel

class NewsViewModelFactory(val favouriteRepo: FavouriteRepo, val localDataSource: LocalDataSourceInterface) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return NewsViewModel(favouriteRepo, localDataSource) as T
    }
}