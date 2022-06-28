package com.example.watc.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.watc.R

class IncidenciaRecycleView : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_incidencias)
        val buttonMap: Button = findViewById(R.id.mapa)
        buttonMap.setOnClickListener{
            val intent : Intent = Intent(this, HomeAdmin::class.java)
            startActivity(intent)
        }
    }
}