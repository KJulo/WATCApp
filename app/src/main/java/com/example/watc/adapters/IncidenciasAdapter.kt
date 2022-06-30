package com.example.watc.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.watc.R
import com.example.watc.models.IncidenciasList
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class IncidenciasAdapter (val context: Context, val incidencias: IncidenciasList) :
    RecyclerView.Adapter<IncidenciasAdapter.IncidenciasViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidenciasViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)

        return IncidenciasViewHolder(view)
    }

    override fun onBindViewHolder(holder: IncidenciasViewHolder, position: Int) {
        val incidencia = incidencias[position]
        holder.incidenciaTipo.text = "Tipo de la incidencia: "+incidencia.tipo
        holder.incidenciaDescripcion.text = "Descripción de la incidencia: "+incidencia.descripcion
        val gmt = TimeZone.getTimeZone("GMT+4")
        "2022-06-28 05:03:36.5505+00"
        val sourceFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        holder.incidenciaFecha.text = "Fecha de la incidencia: "+incidencia.fechaemitida
        if (incidencia.isresuelta){
            holder.incidenciaEstado.text = "La incidencia ha sido resuelta."
        }else{
            holder.incidenciaEstado.text = "La incidencia aún no ha sido resuelta."
        }
    }

    override fun getItemCount(): Int {
        return incidencias.size
    }

    class IncidenciasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var incidenciaTipo = itemView.findViewById<TextView>(R.id.tipoIncidencia)
        var incidenciaDescripcion = itemView.findViewById<TextView>(R.id.descripcionIncidencia)
        var incidenciaFecha = itemView.findViewById<TextView>(R.id.fechaEmitidaIncidencia)
        var incidenciaUbicacion = itemView.findViewById<TextView>(R.id.ubicacionIncidencia)
        var incidenciaEstado = itemView.findViewById<TextView>(R.id.estadoResueltoIncidencia)

    }
}