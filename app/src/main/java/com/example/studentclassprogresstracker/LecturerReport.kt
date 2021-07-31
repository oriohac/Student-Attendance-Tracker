package com.example.studentclassprogresstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_lecturer_report.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_student_qrgenerator.*
import kotlinx.android.synthetic.main.user_item.*

class LecturerReport : AppCompatActivity() {
    private lateinit var dateRef: DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var userArrayList: ArrayList<UserL>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
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
                val spinner: String = course_choice?.selectedItem.toString()
if (spinner.equals("CSC101")) {
    val rootRef = FirebaseDatabase.getInstance().reference
    val dateRef = rootRef.child("SigninData").child("CSC101").child("$date")
    dateRef.addValueEventListener(object : ValueEventListener {

        override fun onDataChange(dataSnapshot: DataSnapshot) {
            if (dataSnapshot.exists()) {
                for (ds in dataSnapshot.children) {
                    val present = ds.getValue(UserL::class.java)
                    userArrayList.add(present!!)
                }
                userRecyclerview.adapter = MyAdapter(userArrayList)
            }
        }

        override fun onCancelled(databaseError: DatabaseError) {
            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
        }
    })
}
                if (spinner.equals("CSC111")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC111").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC112")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC112").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC113")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC113").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC211")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC211").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC212")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC212").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC213")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC213").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC311")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC311").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC312")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC312").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC313")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC313").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC314")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC314").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC315")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC315").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC511")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC511").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC512")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC512").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC513")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC513").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC514")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC514").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC515")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC515").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC121")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC121").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC122")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC122").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC123")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC123").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC124")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC124").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC221")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC221").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC222")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC222").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC223")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC223").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC224")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC224").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC321")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC321").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC322")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC322").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC323")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC323").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC324")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC324").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC325")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC325").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC521")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC521").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC522")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC522").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC523")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC523").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC524")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC524").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }
                if (spinner.equals("CSC525")) {
                    val rootRef = FirebaseDatabase.getInstance().reference
                    val dateRef = rootRef.child("SigninData").child("CSC525").child("$date")
                    dateRef.addValueEventListener(object : ValueEventListener {

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (ds in dataSnapshot.children) {
                                    val present = ds.getValue(UserL::class.java)
                                    userArrayList.add(present!!)
                                }
                                userRecyclerview.adapter = MyAdapter(userArrayList)
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d("TAG", databaseError.getMessage()) //Don't ignore potential errors!
                        }
                    })
                }


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
