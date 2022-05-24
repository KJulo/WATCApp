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
        val btnAdmin: Button = findViewById(R.id.button1)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, Home:: class.java)
            startActivity(intent)
        }

        btnAdmin.setOnClickListener{
            val intent: Intent = Intent(this, InicioSesionAdmin:: class.java)
            startActivity(intent);
        }

    }
}