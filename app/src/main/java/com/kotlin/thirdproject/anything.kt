package com.kotlin.thirdproject
import Users
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class anything :AppCompatActivity() {
    val users = Users(this)/// creating databaes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anything)



    }
}