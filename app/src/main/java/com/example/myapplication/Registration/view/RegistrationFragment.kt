package com.example.myapplication.Registration.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.Registration.RegistrationRepo
import com.example.myapplication.Registration.viewmodel.RegistrationViewModel
import com.example.myapplication.Registration.viewmodel.RegistrationViewModelFactory
import com.example.myapplication.Registration.LocalDataSource
import com.example.myapplication.databinding.FragmentSigupBinding
import com.example.myapplication.db.UserEntity


class RegistrationFragment : Fragment() {
    lateinit var viewModel: RegistrationViewModel
    lateinit var binding: FragmentSigupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSigupBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(
            this,
            RegistrationViewModelFactory(RegistrationRepo(LocalDataSource()))).get(RegistrationViewModel::class.java)
        binding.btnsignin.setOnClickListener(View.OnClickListener {
            val myemail = binding.userName.text.toString()
            val mypassword = binding.userPass.text.toString()

            if (myemail.isNotEmpty() && mypassword.isNotEmpty()) {
                val isinserted = viewModel.insertUser(UserEntity(myemail, mypassword)) ?: false
                if (isinserted) {
                    Toast.makeText(requireActivity(), "Inserted Correctly", Toast.LENGTH_SHORT)
                        .show()
                }
                else{
                    Toast.makeText(requireActivity(), "Inserted Correctly", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sigup, container, false)
    }

    companion object {

    }
}