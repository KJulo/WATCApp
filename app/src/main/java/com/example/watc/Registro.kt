package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val Nombre =findViewById<EditText>(R.id.registrarNombre)
        val Correo =findViewById<EditText>(R.id.registrarCorreo)
        val Password =findViewById<EditText>(R.id.registrarContraseña)

        val btnRegistrase: Button = findViewById(R.id.btnRegistrarse)
        val btn: Button = findViewById(R.id.btnVolver)

        btnRegistrase.setOnClickListener{
            val intent: Intent = Intent(this, InicioSesionLogin:: class.java)
            intent.putExtra("Nombre",Nombre.text.toString())
            intent.putExtra("Correo",Correo.text.toString())
            intent.putExtra("Password",Password.text.toString())

            startActivity(intent);

            val toast = Toast.makeText(this, "Se registro correctamente", Toast.LENGTH_LONG)
            toast.show()
        }

        btn.setOnClickListener{
            val intent: Intent = Intent(this, InicioSesionLogin:: class.java)
            startActivity(intent);
        }
    }
}