package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.widget.Toast
import org.w3c.dom.Text

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
            val textlagunaA : String= "Laguna A"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("lagunaA",textlagunaA)
            startActivity(intent)
            toast.show()

        }

        val lagunaB: Button = findViewById(R.id.lagunaB)
        lagunaB.setOnClickListener {
            val textlagunaB : String= "Laguna B"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("lagunaB",textlagunaB)
            startActivity(intent)
            toast.show()
        }

        val lagunaC: Button = findViewById(R.id.lagunaC)
        lagunaC.setOnClickListener {
            val textlagunaC : String= "Laguna C"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("lagunaC",textlagunaC)
            startActivity(intent)

            toast.show()
        }

        val andesA: Button = findViewById(R.id.andesA)
        andesA.setOnClickListener {
            val textandesA : String= "Andes A"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("andesA",textandesA)
            startActivity(intent)
            toast.show()
        }

        val andesC: Button = findViewById(R.id.andesC)
        andesC.setOnClickListener {
            val textandesC : String= "Andes C"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("andesC",textandesC)
            startActivity(intent)
            toast.show()
        }

        val andesB: Button = findViewById(R.id.andesB)
        andesB.setOnClickListener {
            val textandesB : String= "Andes B"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("andesB",textandesB)
            startActivity(intent)

            toast.show()
        }

        val marquesinaA: Button = findViewById(R.id.marquesinaA)
        marquesinaA.setOnClickListener {
            val textmarquesinaA : String= "Marquesina A"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("marquesinaA",textmarquesinaA)
            startActivity(intent)

            toast.show()
        }

        val marquesinaB: Button = findViewById(R.id.marquesinaB)
        marquesinaB.setOnClickListener {
            val textmarquesinaB : String= "Marquesina B"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("marquesinaB",textmarquesinaB)
            startActivity(intent)

            toast.show()
        }

        val cerroA: Button = findViewById(R.id.cerroA)
        cerroA.setOnClickListener {
            val textcerroA : String= "Cerro A"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("cerroA",textcerroA)
            startActivity(intent)
            toast.show()
        }

        val cerroB: Button = findViewById(R.id.cerroB)
        cerroB.setOnClickListener {
            val textcerroB : String= "Cerro B"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("cerroB",textcerroB)
            startActivity(intent)
            toast.show()
        }

        val cerroC: Button = findViewById(R.id.cerroC)
        cerroC.setOnClickListener {
            val textcerroC : String= "Cerro C"
            val intent: Intent = Intent(this, Home::class.java)
            intent.putExtra("cerroC",textcerroC)
            startActivity(intent)
            toast.show()
        }



    }
}