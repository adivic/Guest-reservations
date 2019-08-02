package com.example.guestreservation.Services

import com.example.guestreservation.Model.Guest
import io.reactivex.Observable
import retrofit2.http.GET

interface GuestService {
    @GET("/api/guests")
    fun getGuest() : Observable<List<Guest>>
}