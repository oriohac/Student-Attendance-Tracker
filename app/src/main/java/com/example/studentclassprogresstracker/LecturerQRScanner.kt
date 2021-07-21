package com.example.studentclassprogresstracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_lecturer_qrscanner.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_student_qrgenerator.*
import java.util.*


class LecturerQRScanner : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecturer_qrscanner)





        database = FirebaseDatabase.getInstance().getReference("SigninData")

        scan.setOnClickListener {
            val scanner = IntentIntegrator(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            scanner.setBeepEnabled(true)
            scanner.initiateScan()


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


















/*context = this
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission(context, permissions)) {
                generateQRCode()
            } else {
                requestPermissions(permissions, PERMISSION_REQUEST)
            }
        }else{
            generateQRCode()
        }
    }

    fun generateQRCode(){
        val bitmap = encodeAsBitmap("CodeAndroid",300,300,context)
        createImageFile(bitmap)
        qrcodeimg.setImageBitmap(bitmap)
    }


    fun createImageFile(bitmapScaled : Bitmap?){
        val bytes = ByteArrayOutputStream()
        bitmapScaled?.compress(Bitmap.CompressFormat.PNG, 40, bytes)
        val filepath = Environment.getExternalStorageDirectory().absolutePath + File.separator + "CodeAndroid.png"
        val f = File(filepath)
        f.createNewFile()
        val fo = FileOutputStream(f)
        fo.write(bytes.toByteArray())
        fo.close()
    }

    fun encodeAsBitmap(str: String, WIDTH: Int, HEIGHT: Int, ctx: Context): Bitmap? {
        val result: BitMatrix
        try {
            result = MultiFormatWriter().encode(str,
                BarcodeFormat.QR_CODE, WIDTH, HEIGHT, null)
        } catch (iae: IllegalArgumentException) {
            return null
        }
        val width = result.width
        val height = result.height
        val pixels = IntArray(width * height)
        for (y in 0 until height) {
            val offset = y * width
            for (x in 0 until width) {
                pixels[offset + x] = if (result.get(x, y)) -0x1000000 else -0x1
            }
        }
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height)
//        createImageFile(bitmap)
        return bitmap
    }
    fun checkPermission(context: Context, permissionArray: Array<String>): Boolean {
        var allSuccess = true
        for (i in permissionArray.indices){
            if(checkCallingOrSelfPermission(permissionArray[i]) == PackageManager.PERMISSION_DENIED)
                allSuccess = false
        }
        return allSuccess
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == PERMISSION_REQUEST){
            var allSuccess = true
            for(i in permissions.indices){
                if(grantResults[i] == PackageManager.PERMISSION_DENIED){
                    allSuccess = false
                    var requestAgain = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(permissions[i])
                    if(requestAgain){
                        Toast.makeText(context,"Permission denied",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"Go to settings and enable the permission",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if(allSuccess)
                generateQRCode()

        }
    }*/