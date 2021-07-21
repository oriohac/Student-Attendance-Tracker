package com.example.studentclassprogresstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_admin.*

class Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        adminlogusers.setOnClickListener {
            val i = Intent(applicationContext,AdminLoginUsers::class.java)
            startActivity(i)
        }
    }
}