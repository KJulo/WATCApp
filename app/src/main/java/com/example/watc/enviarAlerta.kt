package com.example.watc

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_enviar_alerta.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File

private val SELECT_ACTIVITY =1
private val SELECT_ACTIVITY2 =2
private val FILE_NAME = "photo.jpg"
private lateinit var photoFile : File

class enviarAlerta : AppCompatActivity() {

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_alerta)
        cargarFoto.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            photoFile= getPhotoFile(FILE_NAME)
            val fileProvider = FileProvider.getUriForFile(this,"com.example.watc.fileprovider",
                photoFile)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,fileProvider)
            if (takePictureIntent.resolveActivity(this.packageManager) != null) {
                startActivityForResult(takePictureIntent, SELECT_ACTIVITY2)
            }
        }
        cargarGaleria.setOnClickListener {
            ImgController.selectPhotofromGallery(this,SELECT_ACTIVITY)
        }
    }

    private fun getPhotoFile(fileName: String): File{
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDir)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == SELECT_ACTIVITY && resultCode == Activity.RESULT_OK) {
            imageUri=data!!.data
            imageSelect_iv.setImageURI(imageUri)
        }
        if (requestCode== SELECT_ACTIVITY2 && resultCode == Activity.RESULT_OK){
            val takenImg = BitmapFactory.decodeFile(photoFile.absolutePath)
            imageSelect_iv.setImageBitmap(takenImg)
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
/*
        val bundle= intent.extras
        val tipoAlerta = bundle?.getString("tipoAlerta")



          val btn: Button = findViewById(R.id.enviar)
          btn.setOnClickListener {
              val intent: Intent = Intent(this, Home::class.java)

              val texDescripcion= findViewById<TextView>(R.id.textAlerta)
              intent.putExtra("Descripcion",texDescripcion.text.toString())
              startActivity(intent)


              val toast = Toast.makeText(this, "La alerta ha sido recibida, enviaremos un guardia al sector del problema", Toast.LENGTH_LONG)
              toast.show()

          }

       val enviar: Button = findViewById(R.id.enviar)
        enviar.setOnClickListener{
            val builder = AlertDialog.Builder(this@enviarAlerta)
            val view = layoutInflater.inflate(R.layout.alerta_enviada, null)
            builder.setView(view)

            val enviada= builder.create()
            enviada.show()


            view.setOnClickListener {
                val intent: Intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
        }

*/ }
