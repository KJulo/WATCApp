package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InicioSesionLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion_login)

        val btn: Button = findViewById(R.id.login)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, Home:: class.java)
            startActivity(intent)
        }
    }
}