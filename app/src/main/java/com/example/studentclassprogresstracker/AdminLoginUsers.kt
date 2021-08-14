package com.example.studentclassprogresstracker

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory

import com.google.android.material.shape.RoundedCornerTreatment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_admin_login_users.*

class AdminLoginUsers : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    lateinit var RoundedCornerTreatment : RoundedCornerTreatment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContentView(R.layout.activity_admin_login_users)
        registerBtn.setOnClickListener {
            createAccount()

        }
        delete.setOnClickListener {
            deleteuser()
        }
        updatebtn.setOnClickListener{
            val Users = userchoicereg.selectedItem.toString()
            val Firstname = firstName.text.toString()
            val Lastname = lastName.text.toString()
            val Username = regusername.text.toString()
            val Email = emailreg.text.toString()
            val Specialid = specialid.text.toString()
            when {
                TextUtils.isEmpty(Username) -> Toast.makeText(this, "Username is required.", Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(Email) -> Toast.makeText(this, "email is required.", Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(Lastname) -> Toast.makeText(this, "surname is required.", Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(Firstname) -> Toast.makeText(this, "firstname is required.", Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(Users) -> Toast.makeText(this, "User Type is required.", Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(Specialid) -> Toast.makeText(this, "SpecialID is required.", Toast.LENGTH_LONG).show()
                else -> {
            update(Users, Firstname, Lastname, Username, Email, Specialid)
        }
                }
        }

        /*val shapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(16.dp)
        )*/
    }

    private fun update(Users: String, Firstname: String, Lastname: String, Username: String, Email: String, Specialid: String) {
        database = FirebaseDatabase.getInstance().getReference("UserData")


        val user = mapOf<String, String>(
            "firstname" to Firstname,
            "lastname" to Lastname,
            "username" to Username,
            "email" to Email,
            "users" to Users,
            "specialid" to Specialid

        )

        database.child(Username).updateChildren(user).addOnSuccessListener{
            firstName.text.clear()
            lastName.text.clear()
            regusername.text.clear()
            emailreg.text.clear()
            specialid.text.clear()
            Toast.makeText(this, "user data updated successfully", Toast.LENGTH_SHORT).show()

        }
    }

    private fun deleteuser() {
       val intent = Intent(applicationContext,  DeleteUser::class.java)
        startActivity(intent)
    }



    private fun createAccount() {
        val password = regpassword.text.toString()
        val username = regusername.text.toString()
        val email = emailreg.text.toString()
        val lastname = lastName.text.toString()
        val firstname = firstName.text.toString()
        val spin: String = userchoicereg.selectedItem.toString()
        val users = spin


        when {
            TextUtils.isEmpty(password) -> Toast.makeText(this, "password is required.", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(username) -> Toast.makeText(this, "Username is required.", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(email) -> Toast.makeText(this, "email is required.", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(lastname) -> Toast.makeText(this, "surname is required.", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(firstname) -> Toast.makeText(this, "firstname is required.", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(users) -> Toast.makeText(this, "User Type is required.", Toast.LENGTH_LONG).show()

            else -> {

                val progressDialog = ProgressDialog(this)
                progressDialog.setTitle("Registering")
                progressDialog.setMessage("wait for registration to complete")
                progressDialog.setCanceledOnTouchOutside(false)
                progressDialog.show()

                val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {

                            saveuserinfo()
                            saveuserdata()
                            progressDialog.dismiss()
                        } else {
                            val message = task.exception!!.toString()
                            Toast.makeText(this, "not registered $message", Toast.LENGTH_LONG)
                                .show()
                            mAuth.signOut()
                            progressDialog.dismiss()
                        }

                    }
            }
        }


    }


    fun saveuserinfo() {

        val Users = userchoicereg.selectedItem.toString()
        val Firstname = firstName.text.toString()
        val Lastname = lastName.text.toString()
        val Username = regusername.text.toString()
        val Email = emailreg.text.toString()
        val Specialid = specialid.text.toString()


        val progressDialog = ProgressDialog(this)



        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = User(Firstname, Lastname, Username, Email,Specialid, Users)

        val uid = FirebaseAuth.getInstance().currentUser!!.uid
        database.child(uid).setValue(user).addOnCompleteListener { task ->

            if (task.isSuccessful) {
                firstName.text.clear()
                lastName.text.clear()
                regusername.text.clear()
                regpassword.text.clear()
                emailreg.text.clear()
                specialid.text.clear()
                progressDialog.dismiss()
                Toast.makeText(this, "Account has been created", Toast.LENGTH_LONG).show()


            } else {
                val message = task.exception!!.toString()
                Toast.makeText(this, "not registered $message", Toast.LENGTH_LONG).show()
                FirebaseAuth.getInstance().signOut()
                progressDialog.dismiss()
            }
        }
    }


    fun saveuserdata(){
        val Users = userchoicereg.selectedItem.toString()
        val Firstname = firstName.text.toString()
        val Lastname = lastName.text.toString()
        val Username = regusername.text.toString()
        val Email = emailreg.text.toString()
        val Specialid = specialid.text.toString()


        val progressDialog = ProgressDialog(this)



        database = FirebaseDatabase.getInstance().getReference("Userdata")
        val user = User(Firstname, Lastname, Username, Email,Specialid, Users)
        database.child(Username).setValue(user).addOnCompleteListener { task ->

            if (task.isSuccessful) {
                firstName.text.clear()
                lastName.text.clear()
                regusername.text.clear()
                regpassword.text.clear()
                emailreg.text.clear()
                specialid.text.clear()
                progressDialog.dismiss()
                Toast.makeText(this, "Account has been created", Toast.LENGTH_LONG).show()


            } else {
                val message = task.exception!!.toString()
                Toast.makeText(this, "not registered $message", Toast.LENGTH_LONG).show()
                FirebaseAuth.getInstance().signOut()
                progressDialog.dismiss()
            }
        }


    }

}

