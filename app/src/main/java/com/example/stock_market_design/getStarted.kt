package com.example.stock_market_design

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.example.stock_market_design.databinding.ActivityGetStartedBinding
import com.google.firebase.auth.FirebaseAuth


class getStarted : AppCompatActivity() {

    private lateinit var binding: ActivityGetStartedBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        binding.getstarted.setOnClickListener {
            startActivity(Intent(this, mobilelogin::class.java))

        }
    }
}