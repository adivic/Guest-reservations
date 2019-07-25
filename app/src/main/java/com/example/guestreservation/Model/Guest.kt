package com.example.guestreservation.Model

import android.os.Parcel
import android.os.Parcelable

class Guest() : Parcelable{
    var firstname: String? = null
    var lastname: String? = null
    var dateFrom: String? = null
    var dateTill: String? = null
    var didPay: Boolean = false

    constructor(parcel: Parcel) : this() {
        firstname = parcel.readString()
        lastname = parcel.readString()
        dateFrom = parcel.readString()
        dateTill = parcel.readString()
        didPay = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstname)
        parcel.writeString(lastname)
        parcel.writeString(dateFrom)
        parcel.writeString(dateTill)
        parcel.writeByte(if (didPay) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Guest> {
        override fun createFromParcel(parcel: Parcel): Guest {
            return Guest(parcel)
        }

        override fun newArray(size: Int): Array<Guest?> {
            return arrayOfNulls(size)
        }
    }
}