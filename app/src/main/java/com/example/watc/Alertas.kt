package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Alertas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alertas)

        val btn: Button = findViewById(R.id.button_second)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val btnViolenciaFisica: Button = findViewById(R.id.violenciaFisica)
        btnViolenciaFisica.setOnClickListener {
            val intent: Intent = Intent(this, enviarAlerta::class.java)
            startActivity(intent)
        }

        val btnViolenciaGenero: Button = findViewById(R.id.violenciaGenero)
        btnViolenciaGenero.setOnClickListener {
            val intent: Intent = Intent(this, enviarAlerta::class.java)
            startActivity(intent)
        }
        val btnOtro: Button = findViewById(R.id.button_otro)
        btnOtro.setOnClickListener {
            val intent: Intent = Intent(this, enviarAlerta::class.java)
            startActivity(intent)
        }
        val btnRacismo: Button = findViewById(R.id.racismo)
        btnRacismo.setOnClickListener {
            val intent: Intent = Intent(this, enviarAlerta::class.java)
            startActivity(intent)
        }
        val btnInclusion: Button = findViewById(R.id.inclusion)
        btnInclusion.setOnClickListener {
            val intent: Intent = Intent(this, enviarAlerta::class.java)
            startActivity(intent)
        }

    }
}