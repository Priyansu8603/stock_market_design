package com.example.stock_market_design.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.stock_market_design.R
import com.example.stock_market_design.databinding.FragmentRegisterFragBinding
import com.example.stock_market_design.mobilelogin


class register_frag : Fragment() {

    private lateinit var binding:FragmentRegisterFragBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterFragBinding.inflate(layoutInflater)
        //main code for this fragment

        binding.loginText.setOnClickListener {
            it.findNavController().navigate(R.id.action_register_frag_to_mobile_login_frag)
        }

        return binding.root
    }


}