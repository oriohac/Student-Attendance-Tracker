package com.example.studentclassprogresstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_student.*

class Student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        toscan.setOnClickListener(){
            val intent = Intent(applicationContext, StudentQRGenerator::class.java)
            startActivity(intent)
        }
        studcheck.setOnClickListener(){
            val intent = Intent(applicationContext, StudentReport::class.java)
            startActivity(intent)
        }
    }
}