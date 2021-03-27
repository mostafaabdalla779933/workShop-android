package com.example.myapplication.login.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
    val TAG="main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= FragmentLoginBinding.inflate(layoutInflater)

        viewModel= ViewModelProvider(this, LoginViewModelFactory(LoginRepo(LocalDataSource()))).get(LoginViewModel::class.java)

        viewModel.getEmails()

        binding.btnlogin.setOnClickListener(View.OnClickListener {

            if(viewModel.validateUser(binding.userName.text.toString(),binding.userPass.text.toString())){
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view,NewsFragment()).commit()
            }else{
                Log.i(TAG, "onCreate: ")
                Toast.makeText(requireContext(),"invaild password",Toast.LENGTH_SHORT)
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