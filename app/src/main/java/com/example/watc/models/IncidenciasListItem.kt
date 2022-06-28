package com.example.watc.models

data class IncidenciasListItem(
    val descripcion: String,
    val fechaemitida: String,
    val isresuelta: Boolean,
    val tipo: String,
    val ubicacion: String
)