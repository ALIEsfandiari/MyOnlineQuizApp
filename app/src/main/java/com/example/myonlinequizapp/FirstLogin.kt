package com.example.myonlinequizapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView

class FirstLogin : AppCompatActivity() {

    lateinit var signUp : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_login)

        signUp = findViewById(R.id.txt_signup)

        signUp.setOnClickListener {
            startActivity(Intent(this,Signup::class.java))
        }

    }
}