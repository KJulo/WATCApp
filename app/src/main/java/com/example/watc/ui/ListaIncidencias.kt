package com.example.watc.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.watc.R
import com.example.watc.adapters.IncidenciasAdapter
import com.example.watc.models.IncidenciasList
import com.example.watc.service.ApiInterface
import kotlinx.android.synthetic.main.activity_lista_incidencias.*
import kotlinx.android.synthetic.main.activity_lista_incidencias.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaIncidencias: AppCompatActivity() {
    val BASE_URL="http://137.184.56.156/"
    lateinit var adapter: IncidenciasAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DEBUG","funcionandoOnCreate")
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_incidencias)
        fetchIncidenciasListHours();
    }

    private fun fetchIncidenciasListHours(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getIncidenciasList()

        retrofitData.enqueue(object : Callback<IncidenciasList?> {
            override fun onResponse(
                call: Call<IncidenciasList?>,
                response: Response<IncidenciasList?>
            ) {
                val responseBody = response.body()!!
                adapter = IncidenciasAdapter(this@ListaIncidencias, responseBody)
                listaIncidencias.adapter = adapter
                listaIncidencias.layoutManager = LinearLayoutManager(this@ListaIncidencias)

            }

            override fun onFailure(call: Call<IncidenciasList?>, t: Throwable) {
            }
        })
    }
}