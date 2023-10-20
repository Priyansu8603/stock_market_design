package com.example.stock_market_design.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.stock_market_design.R
import com.example.stock_market_design.databinding.FragmentContinueWithEmailFragBinding
import com.example.stock_market_design.register

class continue_with_Email_frag : Fragment() {

    private lateinit var binding: FragmentContinueWithEmailFragBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentContinueWithEmailFragBinding.inflate(layoutInflater)
        //main code for this fragment

        binding.txtRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_continue_with_Email_frag_to_register_frag)
        }

        return binding.root
    }

}