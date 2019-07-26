package com.example.guestreservation.Services

import com.example.guestreservation.Model.Guest
import com.example.guestreservation.Rest.ServiceCallback

interface MyTestService {

    fun getAllGuests(callback: ServiceCallback<List<Guest>, Error>)
}