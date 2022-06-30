package com.example.watc.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Build
import android.Manifest
import android.app.Dialog
import android.content.ContentValues
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_enviar_alerta.*
import androidx.appcompat.app.AppCompatActivity
import com.example.watc.R
import com.example.watc.models.*
import com.example.watc.service.ApiInterface
import com.example.watc.ui.controller.ImgController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val SELECT_ACTIVITY =1
private const val PERMISSION_CODE= 2
private const val IMAGE_CAPTURE_CODE= 3


class enviarAlerta : AppCompatActivity() {
    var BASE_URL="http://137.184.56.156/"
    private var imageUri: Uri? = null
    private var imageUri2: Uri? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        val tipoAlerta = intent.getStringExtra("tipoAlerta").toString()
        Log.d("ENVIARALERTA",tipoAlerta)
        val position = intent.getStringExtra("position").toString()
        Log.d("ENVIARALERTA", position)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_alerta)
        val user: user = user(email = "", ido = 1,"Ignacio Silva")

        cargarFoto.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_DENIED
                ) {
                    val permission = arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                    requestPermissions(permission, PERMISSION_CODE)
                } else {
                    openCamera()
                }
            } else {
                openCamera()
            }

        }
        cargarGaleria.setOnClickListener {
            ImgController.selectPhotofromGallery(this, SELECT_ACTIVITY)
        }


        val enviarAlertaButton : Button = findViewById(R.id.enviar)
        enviarAlertaButton.setOnClickListener{
            val textoAlerta = textAlerta.text.toString()
            if (textoAlerta != "") {
                addIncidencia(user,tipoAlerta,position, textoAlerta)
            }else{
                val toast = Toast.makeText(this, "La incidencia debe contener un mensaje.", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }

    private fun showError(){
        val toast = Toast.makeText(this, "Hubo un error al enviar la incidencia, intentelo mas tarde.", Toast.LENGTH_LONG)
        toast.show()
    }

    private fun addIncidencia(user: user, tipoAlerta: String, position: String, description: String ){
        var incidencia: Incidencia = Incidencia(description,"1",tipoAlerta,position)
        var body : bodyIncidencia = bodyIncidencia(incidencia,user)
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.addIncidencia(body)

        retrofitData.enqueue(object : Callback<checkUser?> {
            override fun onResponse(call: Call<checkUser?>, response: Response<checkUser?>) {
                val responseBody = response.body()!!
                Log.d("enviarAlerta", responseBody.toString())
                changeMain();
            }

            override fun onFailure(call: Call<checkUser?>, t: Throwable) {
                showError()
            }
        })
    }

    private fun changeMain(){
        val toast = Toast.makeText(this, "La alerta ha sido recibida, enviaremos un guardia al sector del problema.", Toast.LENGTH_LONG)
        toast.show()
        var dialog = CalificacionAlerta()
        dialog.show(supportFragmentManager,"CalificacionAlerta")
        //val intent: Intent =  Intent(this, CalificacionAlerta::class.java)
        //startActivity(intent);
    }



    private fun openCamera(){
        val values= ContentValues()
        values.put(MediaStore.Images.Media.TITLE,"New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION,"From the camera")
        imageUri2=contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)
        val cameraIntent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri2)
        startActivityForResult(cameraIntent,IMAGE_CAPTURE_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode){
            PERMISSION_CODE->{
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED ) {
                    openCamera()
                }else{
                    Toast.makeText(this,"Permiso denegado",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_CAPTURE_CODE && resultCode==Activity.RESULT_OK){
            imageSelect_iv.setImageURI(imageUri2)
        }
        if (requestCode == SELECT_ACTIVITY && resultCode == Activity.RESULT_OK) {
            imageUri=data!!.data
            imageSelect_iv.setImageURI(imageUri)
        }
    }
}