package com.example.myapplication.login.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.Registration.view.RegistrationFragment
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.login.LocalDataSource
import com.example.myapplication.login.LoginRepo
import com.example.myapplication.login.viewmodel.LoginViewModel
import com.example.myapplication.login.viewmodel.LoginViewModelFactory


class LoginFragment : Fragment() {


    lateinit var viewModel: LoginViewModel
    lateinit var binding: FragmentLoginBinding
    val TAG="main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentLoginBinding.inflate(layoutInflater)

        viewModel= ViewModelProvider(this, LoginViewModelFactory(LoginRepo(LocalDataSource()))).get(LoginViewModel::class.java)

        binding.btnlogin.setOnClickListener(View.OnClickListener {

            if(viewModel.validateUser(binding.userName.text.toString(),binding.userPass.text.toString())){

                Log.i(TAG, "onCreate: success")
            }else{

                Log.i(TAG, "onCreate: failed")
            }


        })


        binding.btnsignin.setOnClickListener(View.OnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view,RegistrationFragment()).commit()

        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return binding.root
    }

    companion object {

    }
}