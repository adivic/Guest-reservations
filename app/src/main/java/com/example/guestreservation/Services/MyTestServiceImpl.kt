package com.example.guestreservation.Services

import com.example.guestreservation.Model.Guest
import com.example.guestreservation.Rest.RestGateway
import com.example.guestreservation.Rest.RetrofitClient
import com.example.guestreservation.Rest.ServiceCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates

class MyTestServiceImpl: MyTestService {

    var restGateway: RestGateway by Delegates.notNull()

    constructor(restGateway: RestGateway = RetrofitClient.retrofit.create(RestGateway::class.java)) {
        this.restGateway = restGateway
    }

    override fun getAllGuests(callback: ServiceCallback<List<Guest>, Error>) {
        val call: Call<List<Guest>> = restGateway.getAllGuests()

        call.enqueue(object : Callback<List<Guest>> {
            override fun onResponse(call: Call<List<Guest>>, response: Response<List<Guest>>) {
                callback.success(response.body()!!)
                return
            }

            override fun onFailure(call: Call<List<Guest>>, t: Throwable) {

            }
        })
    }

    override fun getGuest(callback: ServiceCallback<Guest, Error>) {
        val call: Call<Guest> = restGateway.getGuest()

        call.enqueue(object : Callback<Guest> {
            override fun onResponse(call: Call<Guest>, response: Response<Guest>) {
                callback.success(response.body()!!)
            }

            override fun onFailure(call: Call<Guest>, t: Throwable) {

            }
        })
    }
}