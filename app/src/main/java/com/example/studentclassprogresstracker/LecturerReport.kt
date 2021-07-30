package com.example.studentclassprogresstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_lecturer_report.*
import kotlinx.android.synthetic.main.activity_student_qrgenerator.*
import kotlinx.android.synthetic.main.user_item.*

class LecturerReport : AppCompatActivity() {
    private lateinit var dateRef: DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var userArrayList: ArrayList<UserL>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContentView(R.layout.activity_lecturer_report)
        userRecyclerview = userList
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)






        lectGetStudReport.setOnClickListener {
            userArrayList = arrayListOf<UserL>()
            getDataFrom()
        }

    }

    private fun getDataFrom() {
        val date = editText.text.toString().trim()

      if (date != null) {
            if (date.isEmpty()) {
                Toast.makeText(this, "Enter date in form of 20-10-2021", Toast.LENGTH_LONG).show()
            } else {


                val rootRef = FirebaseDatabase.getInstance().reference
                val dateRef = rootRef.child("SigninData").child("CSC101").child("$date")
                dateRef.addValueEventListener( object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (ds in dataSnapshot.children) {


                                // val value = ds.getValue(String::class.java)

                                val present = ds.getValue(UserL::class.java)
                                userArrayList.add(present!!)


                                val pee = present.toString()
                                //val kee = id.toString()
                                show.text = present.toString()
                                //  Log.d("TAG", id + "/" + present)
                            }
                            userRecyclerview.adapter = MyAdapter(userArrayList)
                        }
                    }
                    override fun onCancelled(databaseError: DatabaseError) {
                        Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                    }
                })
               // dateRef.addListenerForSingleValueEvent(valueEventListener)

                }
            }
        }

    }




/*val rootRef = FirebaseDatabase.getInstance().reference
val dateRef = rootRef.child("SigninData").child("CSC101").child("21-6-21")
val valueEventListener = object : ValueEventListener {
    override fun onDataChange(dataSnapshot: DataSnapshot) {
        for (ds in dataSnapshot.children) {
            val key = ds.getKey()
            val value = ds.getValue(String::class.java)
            Log.d("TAG", "$key/$value")
        }
    }

    override fun onCancelled(databaseError: DatabaseError) {
        Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
    }
}
dateRef.addListenerForSingleValueEvent(valueEventListener)*/











/*
private fun getDataFrom(date: String) {
    val rootRef = FirebaseDatabase.getInstance().reference
    val dateRef = rootRef.child("SigninData").child("CSC101").child(date)
    val valueEventListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            for (ds in dataSnapshot.children) {
                val key = ds.getKey()
                val value = ds.getValue(String::class.java)
                Log.d("TAG", "$key/$value")
            }
        }

        override fun onCancelled(databaseError: DatabaseError) {
            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
        }
    }
    dateRef.addListenerForSingleValueEvent(valueEventListener)
}*/








/*

// val rootRef = FirebaseDatabase.getInstance().reference

dateRef = FirebaseDatabase.getInstance().getReference("SigninData").child("CSC101").child("$date")

dateRef.addValueEventListener( object : ValueEventListener {
    override fun onDataChange(dataSnapshot: DataSnapshot) {
        if (dataSnapshot.exists()) {
            for (ds in dataSnapshot.children) {

                val id = ds.getValue(UserL::class.java)
                val present = ds.getValue(UserL::class.java)
                userArrayList.add(present!!)
                userArrayList.add(id!!)
                //show.setText(value)
                //Log.d("TAG", "$key/$value")
            }

            userRecyclerView.adapter = MyAdapter(userArrayList)
        }
    }
    override fun onCancelled(databaseError: DatabaseError) {
        Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
    }
})
dateRef.addListenerForSingleValueEvent(valueEventListener)*/
