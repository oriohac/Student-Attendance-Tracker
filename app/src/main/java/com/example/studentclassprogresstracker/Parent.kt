package com.example.studentclassprogresstracker

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_admin_login_users.*
import kotlinx.android.synthetic.main.activity_parent.*
import kotlinx.android.synthetic.main.activity_parent_report.*

class Parent : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContentView(R.layout.activity_parent)
        checkprog.setOnClickListener(){
            val intent = Intent(applicationContext, ParentReport::class.java)
            startActivity(intent)
        }

    }

   /* private fun readData(id: String) {
        val uid = FirebaseAuth.getInstance().uid!!
database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uid).get().addOnSuccessListener {
            if (it.exists()){

                val email = it.child(id).value
                Toast.makeText(this@Parent, "added", Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext, ParentReport::class.java)
                txtparentreport.text = email.toString()
                startActivity(intent)

            }else{
                Toast.makeText(this@Parent, "User does not exist", Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this@Parent, "Failed", Toast.LENGTH_LONG).show()
        }
    }*/


    private fun getReport() {

        val uid = FirebaseAuth.getInstance().currentUser!!.uid
        val rootRef = FirebaseDatabase.getInstance().reference
        val uidRef = rootRef.child("Users").child("email")
        val enterid = childid.text.toString()




        val valueEventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                if (dataSnapshot.child("email").getValue(String::class.java) == enterid){
                    val intent = Intent(applicationContext, ParentReport::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@Parent, "Enter Special Id", Toast.LENGTH_LONG).show()
                }
                }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d(TAG, databaseError.message)
            }
        }
        uidRef.addListenerForSingleValueEvent(valueEventListener)


    }
    /*ValueEventListener valueEventListener = new ValueEventListener(){
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            artistList.clear();
            if (dataSnapshot.exists()){
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Artist artist = snapshot.getValue(Artist.class);
                    artistList.add(artist);
                }
                adapter.notifyDataSetChanged();
            }
        }
        @Override
        public void onCancelled(DatabaseError databaseError)

    }*/

}


//  UPDATE FIELD
//  ref.child("myDb").child("awais@gmailcom").child("leftSpace").setValue("YourDateHere");