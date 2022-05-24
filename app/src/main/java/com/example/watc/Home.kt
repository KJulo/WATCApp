package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btn: Button = findViewById(R.id.tengoProblema)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, Alertas:: class.java)
            startActivity(intent)
        }
    }
}