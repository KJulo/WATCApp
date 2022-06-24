package com.example.watc.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.watc.R
import com.example.watc.models.ubicaciones
import com.example.watc.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MapaFragment : Fragment() {
    val BASE_URL = "http://137.184.56.156/"
    var ubicaciones: ubicaciones = ubicaciones()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchIncidencias()
    }

    private fun fetchIncidencias() {
        val retrofitBuider = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuider.getIncidencias()

        retrofitData.enqueue(object : Callback<ubicaciones?> {
            override fun onResponse(call: Call<ubicaciones?>, response: Response<ubicaciones?>) {
                val responseBody = response.body()!!
                ubicaciones = responseBody
            }

            override fun onFailure(call: Call<ubicaciones?>, t: Throwable) {

            }
        })
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root: View = inflater.inflate(R.layout.activity_incidencia_mapa, container, false)
        Log.d("ACA",ubicaciones.toString())
        for (item in ubicaciones) {
            when (item.ubicacion) {
                "Laguna A" -> {
                    val txtView: TextView = root.findViewById(R.id.andesA)

                }
                "Laguna B" -> print("")
                "Laguna C" -> print("")
                "Andes A" -> print("")
                "Andes B" -> print("")
                "Andes C" -> print("")
                "Marquesina A" -> print("")
                "Marquesina B" -> {
                    Log.d("ACA", "ACA PASOO JOJO")
                    val txtView: TextView = root.findViewById(R.id.marquesinaB)
                    txtView.text = item.count
                }
                "Cerro A" -> print("")
                "Cerro B" -> print("")
                "Cerro C" -> print("")
                else -> {}
            }

        }
        return inflater.inflate(R.layout.activity_incidencia_mapa, container, false)
    }


}