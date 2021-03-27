package com.example.myapplication.login.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MyApplication
import com.example.myapplication.News.NewsViewModel
import com.example.myapplication.News.NewsFragment
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
    val TAG = "main"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentLoginBinding.inflate(layoutInflater)

        viewModel= ViewModelProvider(this, LoginViewModelFactory(LoginRepo(LocalDataSource()))).get(LoginViewModel::class.java)

        viewModel.getEmails()

        binding.btnlogin.setOnClickListener(View.OnClickListener {

            val username:String?=binding.userName.text.toString()
            val password:String?=binding.userPass.text.toString()
            if(username.isNullOrEmpty()){
                Toast.makeText(requireActivity(),"PLease fill Username Field",Toast.LENGTH_SHORT).show()
            }
            else{
                if (password.isNullOrEmpty()){
                    Toast.makeText(requireActivity(),"PLease fill Password Field",Toast.LENGTH_SHORT).show()
                }
                else{
                    if(viewModel.validateUser(username,password)){

                        Toast.makeText(requireActivity(),"Login Successeded",Toast.LENGTH_SHORT).show()
                        parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view,NewsFragment()).commit()
                    }else{
                        Toast.makeText(requireActivity(),"Invalid Username/Password",Toast.LENGTH_SHORT).show()
                    }
                }
            }



        })


        binding.btnsignin.setOnClickListener(View.OnClickListener {

            parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view,RegistrationFragment()).commit()

        })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel.emailsLiveData.observe(viewLifecycleOwner, Observer {

            var adapter1: ArrayAdapter<String> = ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,it!!.toMutableList()
            )
            binding.userName.threshold=1
            binding.userName.setAdapter(adapter1)
        })





        return binding.root
    }

    companion object {

    }
}