package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.login.view.LoginFragment


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,LoginFragment()).commit()

    }
}