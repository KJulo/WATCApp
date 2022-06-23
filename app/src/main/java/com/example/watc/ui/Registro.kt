package com.example.watc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.watc.R
import com.example.watc.models.register
import com.example.watc.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Registro : AppCompatActivity() {
    var BASE_URL="http://137.184.56.156/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val Nombre =findViewById<EditText>(R.id.registrarNombre).text.toString()
        val Correo =findViewById<EditText>(R.id.registrarCorreo).text.toString()
        val Password =findViewById<EditText>(R.id.registrarContraseña).text.toString()

        val btnRegistrase: Button = findViewById(R.id.btnRegistrarse)
        val btn: Button = findViewById(R.id.btnVolver)

        btnRegistrase.setOnClickListener{
            if (Nombre != "" && Correo != "" && Password != ""){
                addUser(Nombre,Correo,Password);
            }
        }

        btn.setOnClickListener{
            val intent: Intent = Intent(this, InicioSesionLogin:: class.java)
            startActivity(intent);
        }
    }

    private fun changeMain(){
        val toast = Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_LONG)
        toast.show()
        val intent: Intent = Intent(this, InicioSesionLogin:: class.java)
        startActivity(intent);
    }

    private fun showError(){
        val toast = Toast.makeText(this, "Hubo un error en el registro", Toast.LENGTH_LONG)
        toast.show()
    }

    private fun addUser(textNombre: String, textMail: String, textContrasena: String){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.addUser(textNombre, textMail, textContrasena)

        retrofitData.enqueue(object : Callback<register?> {
            override fun onResponse(call: Call<register?>, response: Response<register?>) {
                val responseBody = response.body()!!
                if (responseBody.register.toString() == "Usuario creado exitosamente"){
                    changeMain()
                }else{
                    showError()
                }
            }

            override fun onFailure(call: Call<register?>, t: Throwable) {
                showError()
            }
        })
    }
}