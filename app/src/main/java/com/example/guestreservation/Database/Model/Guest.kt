package com.example.guestreservation.Database.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(indices = arrayOf(Index(value = arrayOf("firstname", "lastname"), unique = true)))
class Guest {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var userId: Long = 0
    @ColumnInfo(name = "firstname")
    var firstname: String? = null
    @ColumnInfo(name = "lastname")
    var lastname: String? = null
    @ColumnInfo(name = "date_from")
    var dateFrom: String? = null
    @ColumnInfo(name = "date_till")
    var dateTill: String? = null
    @ColumnInfo(name = "did_pay")
    var didPay: Boolean = false
    @ColumnInfo(name = "description")
    var description: String? = null
}