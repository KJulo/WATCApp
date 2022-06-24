package com.example.watc.ui


import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.watc.R
import com.example.watc.models.ubicaciones
import com.example.watc.service.ApiInterface
import com.example.watc.ui.fragments.FragmentAdapter
import com.example.watc.ui.fragments.IncidenciasFragment
import com.example.watc.ui.fragments.MapaFragment
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeAdmin : AppCompatActivity() {
    val BASE_URL="http://137.184.56.156/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incidencia_mapa)
        fetchIncidencias()

//        var viewPager:ViewPager = findViewById(R.id.viewPager) as ViewPager
//        var tabLayout:TabLayout = findViewById(R.id.tablayout) as TabLayout
//
//        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
//
//        fragmentAdapter.addFragment(MapaFragment(),"Mapa")
//        fragmentAdapter.addFragment(IncidenciasFragment(),"Incidencias")
//
//        viewPager.adapter = fragmentAdapter
//        tabLayout.setupWithViewPager(viewPager)
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
                for (item in responseBody) {
                    when (item.ubicacion) {
                        "Laguna A" -> {
                            val txtView: TextView = findViewById(R.id.lagunaA)

                        }
                        "Laguna B" -> {
                            val txtView: TextView = findViewById(R.id.lagunaB)
                            txtView.text = item.count
                        }
                        "Laguna C" -> {
                            val txtView: TextView = findViewById(R.id.lagunaC)
                            txtView.text = item.count
                        }
                        "Andes A" -> {
                            val txtView: TextView = findViewById(R.id.andesA)
                            txtView.text = item.count
                        }
                        "Andes B" -> {
                            val txtView: TextView = findViewById(R.id.andesB)
                            txtView.text = item.count
                        }
                        "Andes C" -> {
                            val txtView: TextView = findViewById(R.id.andesC)
                            txtView.text = item.count
                        }
                        "Marquesina A" -> {
                            val txtView: TextView = findViewById(R.id.marquesinaA)
                            txtView.text = item.count
                        }
                        "Marquesina B" -> {
                            val txtView: TextView = findViewById(R.id.marquesinaB)
                            txtView.text = item.count
                        }
                        "Cerro A" -> {
                            val txtView: TextView = findViewById(R.id.cerroA)
                            txtView.text = item.count
                        }
                        "Cerro B" -> {
                            val txtView: TextView = findViewById(R.id.cerroB)
                            txtView.text = item.count
                        }
                        "Cerro C" -> {
                            val txtView: TextView = findViewById(R.id.cerroC)
                            txtView.text = item.count
                        }
                        else -> {}
                    }

                }
            }

            override fun onFailure(call: Call<ubicaciones?>, t: Throwable) {

            }
        })
    }



}