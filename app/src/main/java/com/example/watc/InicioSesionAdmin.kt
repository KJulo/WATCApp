package com.example.watc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InicioSesionAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)

        val btn: Button = findViewById(R.id.volver)
        val btnLogin: Button = findViewById(R.id.login)

        btnLogin.setOnClickListener{
            val intent: Intent = Intent(this, HomeAdmin:: class.java)
            startActivity(intent);
        }

        btn.setOnClickListener{
            val intent: Intent = Intent(this, InicioSesionLogin:: class.java)
            startActivity(intent);
        }


    }
}