package com.example.myapplication.sigup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSigupBinding

class SigupFragment : Fragment() {

    lateinit var sigupBinding: FragmentSigupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sigupBinding= FragmentSigupBinding.inflate(layoutInflater)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {





        return sigupBinding.root
    }

    companion object {

    }
}