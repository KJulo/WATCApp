package com.example.watc.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.watc.R
import com.example.watc.models.IncidenciasList
import com.example.watc.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaIncidencias: AppCompatActivity() {
    val BASE_URL="http://137.184.56.156/"
    override fun onCreate(savedInstanceState: Bundle?) {
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
        val retrofitData = retrofitBuilder.getIncidenciasListHours()

        retrofitData.enqueue(object : Callback<IncidenciasList?> {
            override fun onResponse(
                call: Call<IncidenciasList?>,
                response: Response<IncidenciasList?>
            ) {
                val reponseBody = response.body()!!
            }

            override fun onFailure(call: Call<IncidenciasList?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}