package com.example.myonlinequizapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var camera : Button
    lateinit var gallery: Button
    lateinit var avatar : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        camera = findViewById(R.id.btn_camera)
        gallery = findViewById(R.id.btn_gallery)
        avatar = findViewById(R.id.img_avatar)

        camera.setOnClickListener {

            var cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent,1000)

        }

        gallery.setOnClickListener {

            val galleryIntent = Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent,2000)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1000 && resultCode == RESULT_OK && data != null){

            val imageData = data?.getExtras()?.get("data") as Bitmap
            avatar.setImageBitmap(imageData)

        }

        if(requestCode == 2000 && resultCode == Activity.RESULT_OK && data != null){

            val contentURI = data?.getData()
            val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver,contentURI)
            avatar.setImageBitmap(bitmap)

        }


        }

}