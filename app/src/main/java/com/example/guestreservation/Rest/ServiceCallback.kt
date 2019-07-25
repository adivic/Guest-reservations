package com.example.guestreservation.Rest

interface ServiceCallback<T, U> {
    fun success(t: T)
    fun error(u: U)
}