package com.example.stock_market_design.ui.fragments

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.stock_market_design.databinding.FragmentContinueWithNumberFragBinding
import com.example.stock_market_design.enterotp
import com.example.stock_market_design.ui.activities.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.hbb20.CountryCodePicker


class continue_with_number_frag : Fragment() {

    private lateinit var binding: FragmentContinueWithNumberFragBinding
    private lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentContinueWithNumberFragBinding.inflate(layoutInflater)
        //main code for this fragment
        auth = FirebaseAuth.getInstance()
        val progressBar = requireView().findViewById(com.example.stock_market_design.R.id.progressBar) as ProgressBar
        val ccp = requireView().findViewById(com.example.stock_market_design.R.id.ccp) as CountryCodePicker

        progressBar.visibility = View.GONE

        if (auth.currentUser!=null){
            val intent = Intent(activity, MainActivity::class.java)
            activity?.startActivity(intent)
            activity?.finish()
        }
        else{
            binding.editTextPhone.requestFocus()
            binding.btngenerate.setOnClickListener {

                if (binding.editTextPhone.text!!.isEmpty() ){
                    Toast.makeText(,"Please enter a Valid Phone No...", Toast.LENGTH_LONG).show()
                }
                else{
                    var fullnumber  =  "+"+ccp.selectedCountryCode+binding.editTextPhone.text!!
                    progressBar.visibility =View.VISIBLE
                    val intent = Intent(this@contwithnumber, enterotp::class.java)
                    intent.putExtra("number", binding.editTextPhone.text.toString())

                    startActivity(intent)
                    finishAffinity()
                }
            }

        }


    }

        return binding.root
    }

}