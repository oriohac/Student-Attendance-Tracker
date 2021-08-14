package com.example.studentclassprogresstracker

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.app.ProgressDialog.show
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContentView(R.layout.activity_login)




        loginbtn.setOnClickListener {
            loginUser()

            //movetousers()
        }




    }

    private fun movetousers() {
        val spin: String = userchioce.selectedItem.toString()


        if (spin.equals("Admin")) {
            val intent = Intent(applicationContext, Admin::class.java)
            startActivity(intent)
        }
        if (spin.equals("Student")) {
            val intent = Intent(applicationContext, Student::class.java)
            startActivity(intent)
        }
        if (spin.equals("Lecturer")) {
            val intent = Intent(applicationContext, Lecturer::class.java)
            startActivity(intent)
        }
        if (spin.equals("Parent")) {
            val intent = Intent(applicationContext, Parent::class.java)
            startActivity(intent)
        }


    }


    fun loginUser() {
        val Password: String = loginpassword?.text.toString()
        val Email: String = loginEmail?.text.toString()


        when {
            TextUtils.isEmpty(Email) -> Toast.makeText(this, "Enter Email or Username", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(Password) -> Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show()


            else -> {
                val progressDialog = ProgressDialog(this)
                progressDialog.setTitle("Login")
                progressDialog.setMessage("Authenticating...")
                progressDialog.setCanceledOnTouchOutside(false)
                progressDialog.show()
                val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

                mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {


                        val uid = FirebaseAuth.getInstance().currentUser!!.uid

                        val rootRef = FirebaseDatabase.getInstance().reference
                        val uidRef = rootRef.child("Users").child(uid)
                        val spin: String = userchioce.selectedItem.toString()
                    val valueEventListener: ValueEventListener = object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            when {
                                    dataSnapshot.child("users").getValue(String::class.java) == "Admin" -> {
                                        if (spin.equals("Admin")){
                                    val intent = Intent(this@Login, Admin::class.java)
                                    startActivity(intent)}
                                        else{
                                            Toast.makeText(this@Login, "Select Your User-Type", Toast.LENGTH_SHORT)
                                                .show()
                                        }
                                }

                                dataSnapshot.child("users").getValue(String::class.java) == "Lecturer" -> {
                                    if (spin.equals("Lecturer")) {
                                        val intent = Intent(this@Login, Lecturer::class.java)
                                        startActivity(intent)
                                    }else{
                                        Toast.makeText(this@Login, "Select Your User-Type", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                                dataSnapshot.child("users").getValue(String::class.java) == "Parent" -> {
                                    if (spin.equals("Parent")) {
                                        val intent = Intent(this@Login, Parent::class.java)
                                        startActivity(intent)
                                    }else{
                                        Toast.makeText(this@Login, "Select Your User-Type", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                                dataSnapshot.child("users").getValue(String::class.java) == "Student" -> {
                                    if (spin.equals("Student")) {
                                        val intent = Intent(this@Login, Student::class.java)
                                        startActivity(intent)
                                    }else{
                                        Toast.makeText(this@Login, "Select Your User-Type", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                            }
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            Log.d(TAG, databaseError.message)
                        }
                    }
                    uidRef.addListenerForSingleValueEvent(valueEventListener)
                        progressDialog.dismiss()
                    } else {
                        val message = task.exception!!.toString()
                        Toast.makeText(this, "not registered $message", Toast.LENGTH_LONG)
                            .show()
                        FirebaseAuth.getInstance().signOut()
                        progressDialog.dismiss()
                    }
                }
                }

            }


        }


    }














/*val uid = FirebaseAuth.getInstance().currentUser!!.uid
val rootRef = FirebaseDatabase.getInstance().reference
val uidRef = rootRef.child("users").child(uid)
val valueEventListener: ValueEventListener = object : ValueEventListener {
    override fun onDataChange(dataSnapshot: DataSnapshot) {
        if (dataSnapshot.child("Type").getValue(Long::class.java) == 1) {
            startActivity(Intent(this@MainActivity, student::class.java))
        } else if (dataSnapshot.child("TYPE").getValue(Long::class.java) == 2) {
            startActivity(Intent(this@MainActivity, teacher::class.java))
        } else if (dataSnapshot.child("TYPE").getValue(Long::class.java) == 3) {
            startActivity(Intent(this@MainActivity, admin::class.java))
        }
    }

    override fun onCancelled(databaseError: DatabaseError) {
        Log.d(TAG, databaseError.message)
    }
}
uidRef.addListenerForSingleValueEvent(valueEventListener)*/


/*val uid = FirebaseAuth.getInstance().currentUser!!.uid
                          val rootRef = FirebaseDatabase.getInstance().reference
                          val uidRef = rootRef.child("Users").child(uid)
                          val valueEventListener: ValueEventListener = object : ValueEventListener {
                              override fun onDataChange(dataSnapshot: DataSnapshot) {
                                  when {
                                      dataSnapshot.child("users").getValue(String::class.java) == "Admin" -> {
                                          val intent = Intent(this@Login, Admin::class.java)
                                          startActivity(intent)
                                      }
                                      dataSnapshot.child("users").getValue(String::class.java) == "Lecturer" -> {
                                          val intent = Intent(this@Login, Lecturer::class.java)
                                          startActivity(intent)
                                      }
                                      dataSnapshot.child("users").getValue(String::class.java) == "Student" -> {
                                          val intent = Intent(this@Login, Student::class.java)
                                          startActivity(intent)
                                      }
                                  }
                              }

                              override fun onCancelled(databaseError: DatabaseError) {
                                  Log.d(TAG, databaseError.message)
                              }
                          }
                          uidRef.addListenerForSingleValueEvent(valueEventListener)*/