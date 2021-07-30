package com.example.studentclassprogresstracker

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_lecturer_qrscanner.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_student_qrgenerator.*
import java.util.*


class StudentQRGenerator : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        setContentView(R.layout.activity_student_qrgenerator)




        generateQRcode.setOnClickListener {
            val data = qrtext.text.toString().trim()

            if (data.isEmpty() ) {
                Toast.makeText(this, "Enter Value", Toast.LENGTH_SHORT).show()
            } else {
                /*val calen = Calendar.getInstance()
                val d = calen.get(Calendar.HOUR_OF_DAY)
                val day = calen.get(Calendar.DAY_OF_WEEK)*/
                val cur = FirebaseAuth.getInstance().currentUser!!.email
                val obj = Date()
                val date = "$cur You signed in for $data on $obj"


                val writer = QRCodeWriter()
                try {
                    val bitmatrix = writer.encode(date, BarcodeFormat.QR_CODE, 512, 512)
                    val width = bitmatrix.width
                    val height = bitmatrix.height
                    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
                    for (x in 0 until width) {
                        for (y in 0 until height) {
                            bmp.setPixel(x, y, if (bitmatrix[x, y]) Color.BLACK else Color.WHITE)
                        }
                    }
                    qrcodeimg.setImageBitmap(bmp)
                } catch (e: WriterException) {
                    e.printStackTrace()
                }
            }
        }


        val values = arrayListOf(
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
        val mlistview = courses_list
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)
        mlistview.adapter = adapter
        mlistview.setOnItemClickListener { parent, view, position, id ->

            if (position == 1) {
                val text = values[1]
                qrtext.setText(text)
            }
            if (position == 2) {
                val text = values[2]
                qrtext.setText(text)
            }
            if (position == 3) {
                val text = values[3]
                qrtext.setText(text)
            }
            if (position == 4) {
                val text = values[4]
                qrtext.setText(text)
            }
            if (position == 6) {
                val text = values[6]
                qrtext.setText(text)
            }
            if (position == 7) {
                val text = values[7]
                qrtext.setText(text)
            }
            if (position == 8) {
                val text = values[8]
                qrtext.setText(text)
            }

            if (position == 10) {
                val text = values[10]
                qrtext.setText(text)
            }
            if (position == 11) {
                val text = values[11]
                qrtext.setText(text)
            }
            if (position == 12) {
                val text = values[12]
                qrtext.setText(text)
            }
            if (position == 13) {
                val text = values[13]
                qrtext.setText(text)
            }
            if (position == 14) {
                val text = values[14]
                qrtext.setText(text)
            }

            if (position == 16) {
                val text = values[16]
                qrtext.setText(text)
            }
            if (position == 17) {
                val text = values[17]
                qrtext.setText(text)
            }
            if (position == 18) {
                val text = values[18]
                qrtext.setText(text)
            }
            if (position == 19) {
                val text = values[19]
                qrtext.setText(text)
            }
            if (position == 20) {
                val text = values[20]
                qrtext.setText(text)
            }
            if (position == 22) {
                val text = values[22]
                qrtext.setText(text)
            }
            if (position == 23) {
                val text = values[23]
                qrtext.setText(text)
            }
            if (position == 24) {
                val text = values[24]
                qrtext.setText(text)
            }
            if (position == 25) {
                val text = values[25]
                qrtext.setText(text)
            }

            if (position == 27) {
                val text = values[27]
                qrtext.setText(text)
            }
            if (position == 28) {
                val text = values[28]
                qrtext.setText(text)
            }

            if (position == 29) {
                val text = values[29]
                qrtext.setText(text)
            }
            if (position == 30) {
                val text = values[30]
                qrtext.setText(text)
            }
            if (position == 32) {
                val text = values[32]
                qrtext.setText(text)
            }
            if (position == 33) {
                val text = values[33]
                qrtext.setText(text)
            }
            if (position == 34) {
                val text = values[34]
                qrtext.setText(text)
            }

            if (position == 35) {
                val text = values[35]
                qrtext.setText(text)
            }
            if (position == 36) {
                val text = values[36]
                qrtext.setText(text)
            }
            if (position == 38) {
                val text = values[38]
                qrtext.setText(text)
            }
            if (position == 39) {
                val text = values[39]
                qrtext.setText(text)
            }
            if (position == 40) {
                val text = values[40]
                qrtext.setText(text)
            }
            if (position == 41) {
                val text = values[41]
                qrtext.setText(text)
            }


        }



    }
}