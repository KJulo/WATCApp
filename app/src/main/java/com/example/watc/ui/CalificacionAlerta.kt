package com.example.watc.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.watc.R
import kotlinx.android.synthetic.main.fragment_funiono_alerta.*
import kotlinx.android.synthetic.main.fragment_funiono_alerta.view.*

class CalificacionAlerta : DialogFragment (){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_funiono_alerta, container, false)

        rootView.CancelarBotton.setOnClickListener{
            dismiss()
        }
        rootView.EnviarBotton.setOnClickListener{
            val selectedID = ratingRadioGroup.checkedRadioButtonId
            val radio = rootView.findViewById<RadioButton>(selectedID)
            var ratingResult = radio.text.toString()
            Toast.makeText(context, "Según tu opinión la alerta fue : $ratingResult", Toast.LENGTH_SHORT).show()
            dismiss()
            val intent: Intent = Intent(activity, Home::class.java)
            startActivity(intent)
        }
        return rootView;


    }
}