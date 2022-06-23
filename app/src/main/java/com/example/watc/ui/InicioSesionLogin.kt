package com.example.watc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.watc.R
import com.example.watc.models.checkUser
import com.example.watc.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class InicioSesionLogin : AppCompatActivity() {
    var BASE_URL="http://137.184.56.156/"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion_login)
        val Email =findViewById<EditText>(R.id.editTextTextPersonName)
        val Password =findViewById<EditText>(R.id.editTextTextPassword)
        val btn: Button = findViewById(R.id.login)
        val btnRegistrars: Button = findViewById(R.id.button2)
        val btnAdmin: Button = findViewById(R.id.button1)

        btn.setOnClickListener{
            val email: EditText = findViewById(R.id.editTextTextPersonName)
            val contrasena: EditText = findViewById(R.id.editTextTextPassword)
            var textEmail = email.text
            var textContrasena = contrasena.text
            checkUser(textEmail,textContrasena)
        }

        btnRegistrars.setOnClickListener{
            val intent: Intent = Intent(this, Registro:: class.java)
            startActivity(intent);
        }

        btnAdmin.setOnClickListener{
            val intent: Intent = Intent(this, InicioSesionAdmin:: class.java)
            startActivity(intent);
        }
    }
    private fun changeMain(){
        val intent: Intent = Intent(this, Home:: class.java)
        startActivity(intent)
    }

    private fun showError(){
        val toast = Toast.makeText(this, "Los datos ingresados no son correctos", Toast.LENGTH_LONG)
        toast.show()
    }


    private fun checkUser(textEmail: Editable, textContrasena: Editable) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.checkUser(textEmail.toString(),textContrasena.toString())

        retrofitData.enqueue(object : Callback<checkUser?> {
            override fun onResponse(call: Call<checkUser?>, response: Response<checkUser?>) {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                myStringBuilder.append(responseBody.login.exists)
                if (responseBody.login.exists == true){
                    changeMain()
                }else{
                    showError()
                }
            }
            override fun onFailure(call: Call<checkUser?>, t: Throwable) {
                showError()
            }
        })
    }
}