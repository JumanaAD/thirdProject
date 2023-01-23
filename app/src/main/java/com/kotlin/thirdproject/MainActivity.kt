package com.kotlin.thirdproject

import Users
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_page)

        val loginBtn = findViewById<Button>(R.id.Logbtn)
        val registerBtn = findViewById<Button>(R.id.Regbtn)


        loginBtn.setOnClickListener {
            val intent =Intent(applicationContext,LoginPage::class.java)
          startActivity(intent)
        }
        registerBtn.setOnClickListener(){
            val intent = Intent(applicationContext,RegisterPage::class.java)
            startActivity(intent)
        }

    }



}