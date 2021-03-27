package com.example.myapplication.login.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MyApplication
import com.example.myapplication.News.NewsViewModel
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
        sharedPreferences= MyApplication.getContext().getSharedPreferences("Credentials", Context.MODE_PRIVATE)
        binding = FragmentLoginBinding.inflate(layoutInflater)

        viewModel =
            ViewModelProvider(this, LoginViewModelFactory(LoginRepo(LocalDataSource(),sharedPreferences))).get(LoginViewModel::class.java)

        binding.btnlogin.setOnClickListener(View.OnClickListener {
            val username: String? = binding.userName.text.toString()
            val password: String? = binding.userPass.text.toString()
            if (username.isNullOrEmpty()) {
                Toast.makeText(requireActivity(), "PLease fill Username Field", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (password.isNullOrEmpty()) {
                    Toast.makeText(
                        requireActivity(),
                        "PLease fill Password Field",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (viewModel.validateUser(username, password)) {
                        Toast.makeText(requireActivity(), "Login Successeded", Toast.LENGTH_SHORT)
                            .show()
                       viewModel.SetUserId(username)
                    } else {
                        Toast.makeText(
                            requireActivity(),
                            "Invalid Username/Password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }


        })


        binding.btnsignin.setOnClickListener(View.OnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, RegistrationFragment()).commit()

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    companion object {

    }
}