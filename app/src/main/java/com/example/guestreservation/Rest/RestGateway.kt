package com.example.guestreservation.Rest

import com.example.guestreservation.Model.Guest
import retrofit2.Call
import retrofit2.http.GET

interface RestGateway {

    @GET("/v100/getGuests")
    fun getAllGuests(): Call<List<Guest>>
}