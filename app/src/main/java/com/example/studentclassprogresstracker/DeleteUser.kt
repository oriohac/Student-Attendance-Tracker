package com.example.studentclassprogresstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_delete_user.*

class DeleteUser : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_user)
        deleteuser.setOnClickListener{
            var username = emailtodelete.text.toString()
            if(username.isNotEmpty()) {
                deleteData(username)
            }
            else {
                Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteData(username: String) {
        database = FirebaseDatabase.getInstance().getReference("Userdata")
        database.child(username).removeValue().addOnSuccessListener {
            emailtodelete.text.clear()
            Toast.makeText(this, "User deleted", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}