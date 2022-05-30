package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class enviarAlerta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_alerta)

        val btn: Button = findViewById(R.id.enviar)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}