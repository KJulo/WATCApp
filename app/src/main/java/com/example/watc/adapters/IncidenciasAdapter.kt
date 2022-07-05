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
import java.time.LocalDate
import java.time.OffsetDateTime
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
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("GMT4")
        var consultationDate = sdf.parse(incidencia.fechaemitida)
        holder.incidenciaFecha.text = "Fecha de la incidencia: "+consultationDate.toString().replace("GMT-04:00 2022","")
        holder.incidenciaUbicacion.text = "Zona: "+incidencia.ubicacion
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