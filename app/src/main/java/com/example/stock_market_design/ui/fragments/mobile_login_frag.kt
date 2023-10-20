package com.example.stock_market_design.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.stock_market_design.R
import com.example.stock_market_design.continueWithEmail
import com.example.stock_market_design.contwithnumber
import com.example.stock_market_design.databinding.FragmentMobileLoginFragBinding


class mobile_login_frag : Fragment() {

    private lateinit var binding: FragmentMobileLoginFragBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMobileLoginFragBinding.inflate(layoutInflater)
        //main code for  this fragment

        binding.contwithnum.setOnClickListener {
           it.findNavController().navigate(R.id.action_mobile_login_frag_to_continue_with_number_frag)
        }
        binding.continueWithEmailTxt.setOnClickListener {
            it.findNavController().navigate(R.id.action_mobile_login_frag_to_continue_with_Email_frag)
        }

        return binding.root
    }

}