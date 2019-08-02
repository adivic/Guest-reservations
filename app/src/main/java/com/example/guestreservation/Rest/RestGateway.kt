package com.example.guestreservation.Rest

import com.example.guestreservation.Model.Guest
import io.reactivex.Observable
import retrofit2.http.GET

interface RestGateway {

    @GET("/v100/getGuests")
    fun getAllGuests(): Observable<List<Guest>>
}