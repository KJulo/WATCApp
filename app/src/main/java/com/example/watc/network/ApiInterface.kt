package com.example.watc.service


import com.example.watc.models.*
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @GET("/user")
    fun getUser(): Call<userResponse>

    @GET("/checkUsuarios")
    fun checkUser(@Query("email") email:String, @Query("contrasena")contrasena:String):Call<checkUser>

    @GET("/checkAdministrador")
    fun checkAdmin(@Query("email")email: String, @Query("contrasena")contrasena: String):Call<checkUser>

    @POST("/addUsuario")
    fun addUser(@Query("nombre")nombre:String,@Query("email")email: String, @Query("contrasena")contrasena: String):Call<register>

    @POST("/addIncidencia")
    fun addIncidencia(@Body incidencia:bodyIncidencia):Call<checkUser>

    @GET("/getIncidencias")
    fun getIncidencias():Call<ubicaciones>
}
data class UserDto(val email:String, val contrasena: String)