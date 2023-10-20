package com.example.stock_market_design.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.stock_market_design.R
import com.example.stock_market_design.databinding.FragmentGetStartedFragBinding
import com.example.stock_market_design.ui.activities.MainActivity
import com.google.firebase.auth.FirebaseAuth


class get_started_frag : Fragment() {

    private lateinit var binding: FragmentGetStartedFragBinding
    private lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentGetStartedFragBinding.inflate(layoutInflater)

        //main code for this fragment


        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {

            val intent = Intent(activity, MainActivity::class.java)
            activity?.startActivity(intent)
            activity?.finish()
        }


        binding.getstarted.setOnClickListener {
            it.findNavController().navigate(R.id.action_get_started_frag_to_mobile_login_frag)

        }


        return binding.root
    }

}