package com.kotlin.thirdproject
import Users
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
class RegisterPage :AppCompatActivity() {

    val users = Users(this) /// creating databaes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        val UserPhone = findViewById<EditText>(R.id.phnEdit)
        val Usermail = findViewById<EditText>(R.id.emailEdit)
        val Username = findViewById<EditText>(R.id.NameText)
        val regBTN = findViewById<Button>(R.id.registerbtn)

        // val phn = intent.getStringExtra("phoneNumber") ?: ""
        regBTN.setOnClickListener() {
            val myuser = UserModel(UserPhone.text.toString(), Usermail.text.toString(),Username.text.toString())
            users.AddUser(myuser)
                Toast.makeText(this,"added !", LENGTH_SHORT).show()
            }


        }

    }











