package com.example.guestreservation.Services

import com.example.guestreservation.Model.Guest
import com.example.guestreservation.Rest.RestGateway
import com.example.guestreservation.Rest.RetrofitClient
import io.reactivex.Observable
//
//class GuestServiceImpl: GuestService {
//
//    var restGateway: RestGateway
//
//    constructor(restGateway: RestGateway = RetrofitClient.retrofit.create(RestGateway::class.java)) {
//        this.restGateway = restGateway
//    }
//
//    override fun getGuest(): Observable<List<Guest>> {
//        restGateway.getAllGuests()
//    }
//}