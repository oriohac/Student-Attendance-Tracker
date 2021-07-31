package com.example.studentclassprogresstracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
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

class Lecturer : AppCompatActivity() {

    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContentView(R.layout.activity_lecturer)
toReport.setOnClickListener {
    val intent = Intent(applicationContext, LecturerReport::class.java)
    startActivity(intent)
}

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
        var month = calen.get(Calendar.MONTH)+1
        val year = calen.get(Calendar.YEAR)
        val date: String = "" + day + "-" + month  + "-" + year


        val mylistview = leccourseslist
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, valueOfCourses)
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
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[2]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }
            if (position == 3) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[3]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }
            if (position == 4) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[4]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }
            if (position == 6) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[6]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }
            if (position == 7) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[7]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }
            if (position == 8) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[8]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }

            if (position == 10) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[10]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }
            if (position == 11) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[11]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }
            if (position == 12) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[12]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }
            if (position == 13) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[13]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }
            if (position == 14) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[14]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()

            }

            if (position == 16) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[16]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 17) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[17]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 18) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[18]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 19) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[19]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 20) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[20]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 22) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[22]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 23) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[23]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 24) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[24]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 25) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[25]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }

            if (position == 27) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[27]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 28) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[28]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }

            if (position == 29) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[29]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 30) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[30]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 32) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[32]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 33) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[33]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 34) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[34]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }

            if (position == 35) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[35]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 36) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[36]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 38) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[38]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 39) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[39]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 40) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[40]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
            }
            if (position == 41) {
                database = FirebaseDatabase.getInstance().getReference("SigninData")
                    .child(valueOfCourses[41]).child("$date")
                val scanner = IntentIntegrator(this)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(true)
                scanner.initiateScan()
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

                    val presentid = database.push().key
                   val id = "$presentid"
                    val pres = UserL(result.contents,id)

                   database.child(presentid.toString()).setValue(pres).addOnCompleteListener(
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
    companion object{
        const val FIRSTNAME = "com.example.application.studentclassprogresstracker"

    }
}


