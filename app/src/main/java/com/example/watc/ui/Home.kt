package com.example.watc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.watc.R

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bundle = intent.extras
        val positionSelected = bundle?.getString("tipoAlerta")
        val user = bundle?.getString("Usuario")
        val toast = Toast.makeText(this, "Su ubicacion ha sido guardada", Toast.LENGTH_LONG)
        val btn: Button = findViewById(R.id.tengoProblema)
        btn.setOnClickListener {
            if (positionSelected.toString() != "null"){
                val intent: Intent = Intent(this, Alertas::class.java)
                intent.putExtra("position",positionSelected)
                startActivity(intent)
            }else{
                val toast = Toast.makeText(this, "Por favor, seleccione ubicación", Toast.LENGTH_LONG)
                toast.show()
            }
        }

        val lagunaA: Button = findViewById(R.id.lagunaA)
        lagunaA.setOnClickListener {
            val textlagunaA : String= "Laguna A"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textlagunaA)
            startActivity(intent)
            toast.show()

        }

        val lagunaB: Button = findViewById(R.id.lagunaB)
        lagunaB.setOnClickListener {
            val textlagunaB : String= "Laguna B"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textlagunaB)
            startActivity(intent)
            toast.show()
        }

        val lagunaC: Button = findViewById(R.id.lagunaC)
        lagunaC.setOnClickListener {
            val textlagunaC : String= "Laguna C"
            val itemSelected = textlagunaC
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textlagunaC)
            startActivity(intent)

            toast.show()
        }

        val andesA: Button = findViewById(R.id.andesA)
        andesA.setOnClickListener {
            val textandesA : String= "Andes A"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textandesA)
            startActivity(intent)
            toast.show()
        }

        val andesC: Button = findViewById(R.id.andesC)
        andesC.setOnClickListener {
            val textandesC : String= "Andes C"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textandesC)
            startActivity(intent)
            toast.show()
        }

        val andesB: Button = findViewById(R.id.andesB)
        andesB.setOnClickListener {
            val textandesB : String= "Andes B"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textandesB)
            startActivity(intent)

            toast.show()
        }

        val marquesinaA: Button = findViewById(R.id.marquesinaA)
        marquesinaA.setOnClickListener {
            val textmarquesinaA : String= "Marquesina A"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textmarquesinaA)
            startActivity(intent)

            toast.show()
        }

        val marquesinaB: Button = findViewById(R.id.marquesinaB)
        marquesinaB.setOnClickListener {
            val textmarquesinaB : String= "Marquesina B"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textmarquesinaB)
            startActivity(intent)

            toast.show()
        }

        val cerroA: Button = findViewById(R.id.cerroA)
        cerroA.setOnClickListener {
            val textcerroA : String= "Cerro A"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textcerroA)
            startActivity(intent)
            toast.show()
        }

        val cerroB: Button = findViewById(R.id.cerroB)
        cerroB.setOnClickListener {
            val textcerroB : String= "Cerro B"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textcerroB)
            startActivity(intent)
            toast.show()
        }

        val cerroC: Button = findViewById(R.id.cerroC)
        cerroC.setOnClickListener {
            val textcerroC : String= "Cerro C"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("tipoAlerta",textcerroC)
            startActivity(intent)
            toast.show()
        }
    }
}