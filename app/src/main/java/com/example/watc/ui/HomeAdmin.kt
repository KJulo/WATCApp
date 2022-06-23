package com.example.watc.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.watc.R
import com.example.watc.ui.fragments.FragmentAdapter
import com.example.watc.ui.fragments.IncidenciasFragment
import com.example.watc.ui.fragments.MapaFragment
import com.google.android.material.tabs.TabLayout

class HomeAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)

        var viewPager:ViewPager = findViewById(R.id.viewPager) as ViewPager
        var tabLayout:TabLayout = findViewById(R.id.tablayout) as TabLayout

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(MapaFragment(),"Mapa")
        fragmentAdapter.addFragment(IncidenciasFragment(),"Incidencias")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)


    }

}