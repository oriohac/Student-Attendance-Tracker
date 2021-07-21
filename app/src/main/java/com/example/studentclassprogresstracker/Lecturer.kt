package com.example.studentclassprogresstracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_admin_login_users.*
import kotlinx.android.synthetic.main.activity_lecturer.*
import kotlinx.android.synthetic.main.activity_student_qrgenerator.*
import java.util.*
import java.util.logging.Logger.global

class Lecturer : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecturer)


        val valueOfCourses = arrayListOf(
            "First Semester Year 1",
            "CSC101",
            "CSC111",
            "CSC112",
            "CSC113",
            "First Semester Year 2",
            "CSC211",
            "CSC212",
            "CSC213",
            "First Semester Year 3",
            "CSC311",
            "CSC312",
            "CSC313",
            "CSC314",
            "CSC315",
            "First Semester Year 5",
            "CSC511",
            "CSC512",
            "CSC513",
            "CSC514",
            "CSC515",
            "Second Semester Year 1",
            "CSC121",
            "CSC122",
            "CSC123",
            "CSC124",
            "Second Semester Year 2",
            "CSC221",
            "CSC222",
            "CSC223",
            "CSC224",
            "Second Semester Year 3",
            "CSC321",
            "CSC322",
            "CSC323",
            "CSC324",
            "CSC325",
            "Second Semester Year 5",
            "CSC521",
            "CSC522",
            "CSC523",
            "CSC524",
            "CSC525"
        )
        val calen = Calendar.getInstance()

        val day = calen.get(Calendar.DAY_OF_MONTH)
        var month = calen.get(Calendar.MONTH)
        val year = calen.get(Calendar.YEAR)
        val date: String = "" + day + "-" + month ++  + "-" + year

        val mylistview = leccourseslist
        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, valueOfCourses)
        mylistview.adapter = adapter
        mylistview.setOnItemClickListener { parent, view, position, id ->
            if (position == 1) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[1]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()




            }






            if (position == 2) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }
            if (position == 3) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }
            if (position == 4) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }
            if (position == 6) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }
            if (position == 7) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }
            if (position == 8) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }

            if (position == 10) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }
            if (position == 11) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }
            if (position == 12) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }
            if (position == 13) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }
            if (position == 14) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)

            }

            if (position == 16) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 17) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 18) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 19) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 20) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 22) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 23) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 24) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 25) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }

            if (position == 27) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 28) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }

            if (position == 29) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 30) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 32) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 33) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 34) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }

            if (position == 35) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 36) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 38) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 39) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 40) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }
            if (position == 41) {
                val intent = Intent (applicationContext, LecturerQRScanner::class.java)
                startActivity(intent)
            }


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {

          val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                } else {

                   database.push().setValue(result.contents).addOnCompleteListener(
                        OnCompleteListener<Void?> {

                            Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG)
                                .show()
                        })
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}
