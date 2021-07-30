package com.example.studentclassprogresstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_student.*

class Student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContentView(R.layout.activity_student)
        buttonGENQR.setOnClickListener(){
            val intent = Intent(applicationContext, StudentQRGenerator::class.java)
            startActivity(intent)
        }

    }
}