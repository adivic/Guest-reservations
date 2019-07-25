package com.example.guestreservation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.presentFragmentInContainer(fragment: Fragment, containerId: Int) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    transaction.replace(containerId, fragment)
    transaction.commit()
}