package com.example.guestreservation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.MenuItem
import com.example.guestreservation.Presentation.AddGuest.AddGuestFragment
import com.example.guestreservation.Presentation.ListGuests.GuestListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val addGuestFragment: AddGuestFragment by lazy { AddGuestFragment() }
    private val printGuestFragment: GuestListFragment by lazy { GuestListFragment() }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                presentFragment(addGuestFragment)
                return@OnNavigationItemSelectedListener true
            }
//            R.id.navigation_dashboard -> {
//                presentFragment(addGuestFragment)
//                return@OnNavigationItemSelectedListener true
//            }
            R.id.navigation_notifications -> {
                presentFragment(printGuestFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        setOnNavigationItemSelectedItemByDefault()
    }

    override fun onBackPressed() {
        supportFragmentManager.popBackStack()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun setOnNavigationItemSelectedItemByDefault() {
        nav_view.selectedItemId = R.id.navigation_home
    }

    private fun presentFragment(fragment: Fragment) {
        presentFragmentInContainer(fragment, R.id.container)
    }
}
