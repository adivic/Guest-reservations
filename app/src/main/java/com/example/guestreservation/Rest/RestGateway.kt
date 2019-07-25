package com.example.guestreservation.Rest

import com.example.guestreservation.Model.Guest
import retrofit2.Call
import retrofit2.http.GET

interface RestGateway {

    @GET("/v2/5d36ec583100002b00b07555  ")
    fun getAllGuests(): Call<List<Guest>>

    @GET("/v2/5d36ec583100002b00b07555  ")
    fun getGuest(): Call<Guest>
}