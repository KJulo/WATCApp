package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class enviarAlerta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_alerta)

          val btn: Button = findViewById(R.id.enviar)
          btn.setOnClickListener {
              val intent: Intent = Intent(this, Home::class.java)
              startActivity(intent)


              val toast = Toast.makeText(this, "La alerta a sido resivida, enviaremos un guardia al sector del problema", Toast.LENGTH_LONG)
              toast.show()

          }

       /* val enviar: Button = findViewById(R.id.enviar)
        enviar.setOnClickListener{
            val builder = AlertDialog.Builder(this@enviarAlerta)
            val view = layoutInflater.inflate(R.layout.alerta_enviada, null)
            builder.setView(view)

            val enviada= builder.create()
            enviada.show()


            view.setOnClickListener {
                val intent: Intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
        }*/


    }
}