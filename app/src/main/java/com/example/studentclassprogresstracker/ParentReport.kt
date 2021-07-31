package com.example.studentclassprogresstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_parent_report.*

class ParentReport : AppCompatActivity() {
    private  lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContentView(R.layout.activity_parent_report)
        parentcheck.setOnClickListener {
            val username: String = childid.text.toString()
            if (username.isNotEmpty()){
                readData(username)
            }else{
                Toast.makeText(this, "Enter Special Id", Toast.LENGTH_LONG).show()
            }
        }
    }



    private fun readData(username: String) {
        val uid = FirebaseAuth.getInstance().uid!!

        database = FirebaseDatabase.getInstance().getReference("Userdata")
        database.child(username).get().addOnSuccessListener {
            if (it.exists()){

                val usernsme = it.child("username").value
                val firstname = it.child("firstname").value
                val email = it.child("email").value
                Toast.makeText(this, "added", Toast.LENGTH_LONG).show()
                txtparentreport.text = usernsme.toString()
                txtparentreport.text = firstname.toString()
                txtparentreport.text = email.toString()


            }else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }
}