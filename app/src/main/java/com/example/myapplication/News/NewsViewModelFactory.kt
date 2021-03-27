package com.example.myapplication.News

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Registration.RegistrationRepo
import com.example.myapplication.Registration.viewmodel.RegistrationViewModel

class NewsViewModelFactory(val favouriteRepo: FavouriteRepo) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return NewsViewModel(favouriteRepo) as T
    }
}