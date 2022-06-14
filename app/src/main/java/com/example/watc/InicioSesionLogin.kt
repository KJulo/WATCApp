package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText

import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.watc.entity.checkUser
import com.example.watc.entity.userResponse
import com.example.watc.service.ApiInterface
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://137.184.56.156/"


class InicioSesionLogin : AppCompatActivity() {
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

            /*val intent: Intent = Intent(this, Home:: class.java)
            intent.putExtra("Email",Email.text.toString())
            intent.putExtra("Contrasena",Password.text.toString())
            startActivity(intent)*/

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
                }
            }

            override fun onFailure(call: Call<checkUser?>, t: Throwable) {
                Log.d("Home", "onFailure"+t.message)
            }
        })
    }

    private fun getUser(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getUser()


        retrofitData.enqueue(object : Callback<userResponse?> {
            override fun onResponse(call: Call<userResponse?>, response: Response<userResponse?>) {

                val responseBody = response.body()!!

                val myStringBuilder = StringBuilder()

                myStringBuilder.append(responseBody.data.nombre)
            }

            override fun onFailure(call: Call<userResponse?>, t: Throwable) {
                Log.d("Home", "onFailure"+t.message)
            }
        })
    }


}