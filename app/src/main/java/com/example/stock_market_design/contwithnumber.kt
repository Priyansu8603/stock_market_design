package com.example.stock_market_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.stock_market_design.databinding.ActivityContwithnumberBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.hbb20.CountryCodePicker
import org.w3c.dom.Text
import java.util.concurrent.TimeUnit
import java.util.logging.Logger.global

class contwithnumber : AppCompatActivity() {
    private lateinit var binding:ActivityContwithnumberBinding
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContwithnumberBinding.inflate(layoutInflater)
        setContentView(binding.root)




        auth = FirebaseAuth.getInstance()
        val progressbar = findViewById<ProgressBar>(R.id.progressBar)
        val ccp = findViewById<CountryCodePicker>(R.id.ccp)

        progressbar.visibility = GONE

        if (auth.currentUser!=null){
            startActivity(Intent(this@contwithnumber,MainActivity::class.java))
            finish()
        }
        else{
            binding.editTextPhone.requestFocus()
            binding.btngenerate.setOnClickListener {

                if (binding.editTextPhone.text!!.isEmpty() ){
                    Toast.makeText(this,"Please enter a Valid Phone No...",Toast.LENGTH_LONG).show()
                }
                else{
                    var fullnumber  =  "+"+ccp.selectedCountryCode+binding.editTextPhone.text!!
                    progressbar.visibility =View.VISIBLE
                    val intent = Intent(this@contwithnumber,enterotp::class.java)
                    intent.putExtra("number", binding.editTextPhone.text.toString())

                    startActivity(intent)
                    finishAffinity()
                }
            }

        }


    }



}

