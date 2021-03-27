package com.example.myapplication.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.LoginViewModel
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.login.LocalDataSource
import com.example.myapplication.login.LoginRepo
import com.example.myapplication.login.viewmodel.LoginViewModelFactory


class LoginFragment : Fragment() {


    lateinit var viewModel:LoginViewModel
    lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentLoginBinding.inflate(layoutInflater)

        viewModel= ViewModelProvider(this, LoginViewModelFactory(LoginRepo(LocalDataSource()))).get(LoginViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return binding.root
    }

    companion object {

    }
}