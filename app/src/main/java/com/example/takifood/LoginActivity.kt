package com.example.takifood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        btnBackLoginListener()
        txtRegisterLisener()
        btnLoginListener()
    }
    private fun btnBackLoginListener() {
        L_img_1.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    private fun txtRegisterLisener() {
        txt_register.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
    private fun btnLoginListener() {
        L_btn_1.setOnClickListener{
            startActivity(Intent(this, SettingNav::class.java))
        }
    }
}