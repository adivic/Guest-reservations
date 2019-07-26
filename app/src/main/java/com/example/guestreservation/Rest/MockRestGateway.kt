package com.example.guestreservation.Rest

import com.example.guestreservation.Model.Guest
import retrofit2.Call
import retrofit2.mock.BehaviorDelegate

class MockRestGateway: RestGateway {

    private val delegate: BehaviorDelegate<RestGateway>

    constructor(behaviorDelegate: BehaviorDelegate<RestGateway>) {
        this.delegate = behaviorDelegate
    }

    override fun getAllGuests(): Call<List<Guest>> {
        var guestList = ArrayList<Guest>()
        for (i in 0 .. 10) {
            var guest = Guest()
            guest.firstname = "Test_$i"
            guest.lastname = "Testni_$i"
            guest.dateFrom = "1$i.07.2019"
            guest.dateTill = "2$i.07.2019"
            guest.didPay = true
            guestList.add(guest)
        }
        return delegate.returningResponse(guestList).getAllGuests()
    }
}