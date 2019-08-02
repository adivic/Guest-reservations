package com.example.guestreservation.Database

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.guestreservation.Model.Guest

interface GuestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(guests: List<Guest>)

    @Query("select * from guest")
    fun getAll() : List<Guest>

    @Query("update guest set firstname= :first, lastname=:last, date_from=:from, date_till=:till, did_pay= :didpay, description=:desc where firstname like :first and lastname like :last")
    fun updateGuest(first: String, last: String, from: String, till: String, didpay: Boolean, desc: String)
}