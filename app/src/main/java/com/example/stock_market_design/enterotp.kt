package com.example.stock_market_design

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.stock_market_design.databinding.ActivityEnterotpBinding
import com.example.stock_market_design.ui.activities.MainActivity
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class enterotp : AppCompatActivity() {
    private lateinit var verificationId: String
    private lateinit var binding: ActivityEnterotpBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var progressbar: ProgressBar
    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterotpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.progressBar2.visibility = View.GONE
        binding.Didntrecieve.visibility = View.GONE
        binding.resendotp.visibility = View.GONE
        auth = FirebaseAuth.getInstance()

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Please wait..")
        builder.setTitle("Loading..")
        builder.setCancelable(false)
        dialog = builder.create()
        dialog.show()

        val phoneNumber: String = "+91" + intent.getStringExtra("number")

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(120L, TimeUnit.SECONDS)
            .setActivity(this@enterotp)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    Log.d(TAG, "onVerificationCompleted: $p0")
                    startActivity(Intent(this@enterotp, MainActivity::class.java))
                    dialog.dismiss()
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    Log.w(TAG, "onVerificationFailed", e)
                    if (e is FirebaseAuthInvalidCredentialsException) {
                        // Invalid request
                        Toast.makeText(
                            this@enterotp,
                            "InvalidCredentialsException!!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (e is FirebaseTooManyRequestsException) {
                        // The SMS quota for the project has been exceeded
                        Toast.makeText(this@enterotp, "TooManyRequestsException!!", Toast.LENGTH_SHORT)
                            .show()
                    } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
                        // reCAPTCHA verification attempted with null Activity
                        Toast.makeText(
                            this@enterotp,
                            "MissingActivityForRecaptchaException!!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                    dialog.dismiss()
                }

                override fun onCodeSent(
                    verifyId: String,
                    forceResendingToken: PhoneAuthProvider.ForceResendingToken
                ) {
                    super.onCodeSent(verifyId, forceResendingToken)
                    verificationId = verifyId
                    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.showSoftInput(binding.Didntrecieve, 0)
                    binding.otpView.requestFocus()
                    dialog.dismiss()
                }

            }).build()

        PhoneAuthProvider.verifyPhoneNumber(options)

        binding.btnVerify.setOnClickListener {
            if (binding.otpView.text!!.isEmpty()) {
                Toast.makeText(this, "Please Enter OTP", Toast.LENGTH_LONG).show()

            } else {
                dialog.show()
                val credential =
                    PhoneAuthProvider.getCredential(verificationId, binding.otpView.text.toString())
                auth.signInWithCredential(credential)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Log.d(TAG, "signInWithCredential:success")
                            dialog.dismiss()
                            binding.progressBar2.visibility = View.VISIBLE
                            val user = it.result?.user
                            startActivity(Intent(this, MainActivity::class.java))
                            finishAffinity()
                        } else {
                            Log.d(TAG, "signInWithCredential:failure", it.exception)
                            dialog.dismiss()
                            if (it.exception is FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(this, "Error ${it.exception}", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }

            }

        }


    }


}


