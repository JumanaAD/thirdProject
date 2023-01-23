package com.kotlin.thirdproject
import Users
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginPage : AppCompatActivity() {
    val users = Users(this) /// creating databaes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val logBTN = findViewById<Button>(R.id.LOGINbtn)
        val UserPhone = findViewById<EditText>(R.id.phnEdit)

            val usrPhn = UserPhone.text.toString()
            logBTN.setOnClickListener() {
                if (users.getUSER(usrPhn) != null) {
                    Toast.makeText(this,"added !", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(applicationContext, anything::class.java)
                startActivity(intent)
            }
        }

    }










       // val phn = intent.getStringExtra("phoneNumber") ?: ""
        //val myuser = UserModel(UserPhone.toString(),"")


        /*if (userInfo.isEmpty()) {
            Toast.makeText(this, "NO USER FOUND !", Toast.LENGTH_SHORT).show()
            finish()



        }*/






