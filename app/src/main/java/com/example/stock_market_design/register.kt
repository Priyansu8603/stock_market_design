package com.example.stock_market_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stock_market_design.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class register : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var username:String
    private lateinit var email:String
    private lateinit var password:String
    private lateinit var database:DatabaseReference
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginText.setOnClickListener {
            startActivity(Intent(this,mobilelogin::class.java))
        }
    }
}