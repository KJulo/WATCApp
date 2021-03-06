package com.example.watc.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.widget.Toast
import com.example.watc.R
import com.example.watc.models.checkUser
import com.example.watc.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class InicioSesionAdmin : AppCompatActivity() {
    val BASE_URL="http://137.184.56.156/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)
        val Email =findViewById<EditText>(R.id.editTextTextPersonName2)
        val Password =findViewById<EditText>(R.id.editTextTextPassword2)
        val btn: Button = findViewById(R.id.volver)
        val btnLogin: Button = findViewById(R.id.login)


        btnLogin.setOnClickListener {
            val email: EditText = findViewById(R.id.editTextTextPersonName2)
            val contrasena: EditText = findViewById(R.id.editTextTextPassword2)
            var textEmail = email.text
            var textContrasena = contrasena.text
            checkAdmin(textEmail,textContrasena)

        }

        btn.setOnClickListener {
            val intent: Intent = Intent(this, InicioSesionLogin::class.java)
            startActivity(intent);
        }


    }

    private fun showError(){
        val toast = Toast.makeText(this, "Los datos ingresados no son correctos", Toast.LENGTH_LONG)
        toast.show()
    }

    private fun changeMainAdmin(){
        val intent: Intent = Intent(this, HomeAdmin:: class.java)
        startActivity(intent);
    }

    private fun checkAdmin(textEmail: Editable, textContrasena: Editable){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.checkAdmin(textEmail.toString(),textContrasena.toString())

        retrofitData.enqueue(object : Callback<checkUser?> {
            override fun onResponse(call: Call<checkUser?>, response: Response<checkUser?>) {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                myStringBuilder.append(responseBody.login.exists)
                if (responseBody.login.exists == true){
                    changeMainAdmin()
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