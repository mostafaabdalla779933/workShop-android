package com.example.myapplication.Registration.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.Registration.RegistrationRepo
import com.example.myapplication.Registration.viewmodel.RegistrationViewModel
import com.example.myapplication.Registration.viewmodel.RegistrationViewModelFactory
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.Registration.LocalDataSource


class RegistrationFragment : Fragment() {
    lateinit var viewModel: RegistrationViewModel
    lateinit var binding: FragmentRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentRegistrationBinding.inflate(layoutInflater)

        viewModel= ViewModelProvider(this, RegistrationViewModelFactory(RegistrationRepo(LocalDataSource()))).get(
            RegistrationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    companion object {

    }
}