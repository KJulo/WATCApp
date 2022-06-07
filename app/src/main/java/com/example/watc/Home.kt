package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.widget.Toast

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toast = Toast.makeText(this, "Su ubicacion ha sido guardada", Toast.LENGTH_LONG)
        val btn: Button = findViewById(R.id.tengoProblema)
        btn.setOnClickListener {

            val intent: Intent = Intent(this, Alertas::class.java)
            startActivity(intent)
        }

        val lagunaA: Button = findViewById(R.id.lagunaA)
        lagunaA.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)
            toast.show()

        }

        val lagunaB: Button = findViewById(R.id.lagunaB)
        lagunaB.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)
            toast.show()
        }

        val lagunaC: Button = findViewById(R.id.lagunaC)
        lagunaC.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)

            toast.show()
        }

        val andes: Button = findViewById(R.id.andes)
        andes.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)

            toast.show()
        }

        val marquesina: Button = findViewById(R.id.marquesina)
        marquesina.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)

            toast.show()
        }

        val cerroA: Button = findViewById(R.id.cerroA)
        cerroA.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)

            toast.show()
        }

        val cerroB: Button = findViewById(R.id.cerroB)
        cerroB.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)

            toast.show()
        }



    }
}