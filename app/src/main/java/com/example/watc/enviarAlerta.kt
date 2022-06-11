package com.example.watc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class enviarAlerta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_alerta)

        val bundle= intent.extras
        val tipoAlerta = bundle?.getString("tipoAlerta")
        val envio = findViewById<TextView>(R.id.textTipoAlerta)
        envio.text= tipoAlerta.toString()



          val btn: Button = findViewById(R.id.enviar)
          btn.setOnClickListener {
              val intent: Intent = Intent(this, Home::class.java)

              val texDescripcion= findViewById<TextView>(R.id.textAlerta)
              intent.putExtra("Descripcion",texDescripcion.text.toString())
              intent.putExtra("tipoAlerta",envio.text.toString())
              startActivity(intent)


              val toast = Toast.makeText(this, "La alerta ha sido recibida, enviaremos un guardia al sector del problema", Toast.LENGTH_LONG)
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