package com.example.studentclassprogresstracker

import android.app.ProgressDialog
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_admin_login_users.*

class AdminLoginUsers : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login_users)
        registerBtn.setOnClickListener {
            createAccount()

        }
        updatebtn.setOnClickListener{
            update()
        }
    }

    fun update() {
        val Users = userchoicereg.selectedItem.toString()
        val Firstname = firstName.text.toString()
        val Lastname = lastName.text.toString()
        val Username = regusername.text.toString()
        val Email = emailreg.text.toString()
        val Specialid = specialid.text.toString()
        val uid = FirebaseAuth.getInstance().currentUser!!.uid
        val usersx = User(Firstname,Lastname,Username,Email,Specialid,Users)
        database.child("Users").child(uid).setValue(usersx)
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




/*
val Users  = users.selectedItem.toString()
val Firstname = firstName.text.toString()
val Lastname = lastName.text.toString()
val Username = regusername.text.toString()
val Email = email.text.toString()
//val users = spin


database = FirebaseDatabase.getInstance().getReference("Users")
val user = User(Firstname,Lastname,Username,Email,Users)
database.child(Username).setValue(user).addOnSuccessListener {
    firstName.text.clear()
    lastName.text.clear()
    regusername.text.toString()
    regpassword.text.clear()


    Toast.makeText(this, "successfully saved", Toast.LENGTH_SHORT).show()
}.addOnFailureListener{
    Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
}*/
/*
.addOnSuccessListener {
    firstName.text.clear()
    lastName.text.clear()
    regusername.text.toString()
    regpassword.text.clear()

    val currentuser = FirebaseAuth.getInstance().currentUser!!.uid
    val userRef: DatabaseReference = FirebaseDatabase.getInstance().reference.child("Users")
    val userMap = HashMap<String, Any>()
    userMap["uid"] = currentuser
    userMap["firstname"] = firstname
    userMap["surname"] = lastname
    userMap["username"] = username
    userMap["email"] = email
    userMap["users"] = users

    userRef.child(email).setValue(userMap)
}*/