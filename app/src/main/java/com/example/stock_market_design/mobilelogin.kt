package com.example.stock_market_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stock_market_design.databinding.ActivityMobileloginBinding

class mobilelogin : AppCompatActivity() {
    private lateinit var binding: ActivityMobileloginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMobileloginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.contwithnum.setOnClickListener {
            startActivity(Intent(this,contwithnumber::class.java))
        }
        binding.continueWithEmailTxt.setOnClickListener {
            startActivity(Intent(this,continueWithEmail::class.java))
        }
    }
}