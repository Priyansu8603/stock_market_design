package com.example.stock_market_design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stock_market_design.databinding.ActivityContinueWithEmailBinding

class continueWithEmail : AppCompatActivity() {
    private lateinit var binding: ActivityContinueWithEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContinueWithEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this,register::class.java))
        }
    }
}