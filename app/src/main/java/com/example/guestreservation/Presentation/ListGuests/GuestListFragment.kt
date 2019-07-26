package com.example.guestreservation.Presentation.ListGuests

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guestreservation.MainActivity
import com.example.guestreservation.Model.Guest
import com.example.guestreservation.R
import com.example.guestreservation.Rest.ServiceCallback
import com.example.guestreservation.Services.MyTestService
import com.example.guestreservation.presentFragmentInContainer
import kotlinx.android.synthetic.main.list_guest_fragment.*
import org.koin.android.ext.android.inject
import java.lang.Error

class GuestListFragment : Fragment(), GuestListAdapter.GuestListAdapterListener {

    private lateinit var guestAdapter: GuestListAdapter
    private val service: MyTestService by inject()
    private var guestSelected: Guest? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_guest_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        createRecyclerView()
        addRecyclerViewAdapterToRecyclerView()
        setupRecyclerViewAdapterListener()
        loadData()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
    }

    private fun createRecyclerView() {
        guestAdapter = GuestListAdapter(context!!)
    }

    private fun addRecyclerViewAdapterToRecyclerView() {
        recyclerView.adapter = guestAdapter
    }

    private fun setupRecyclerViewAdapterListener() {
        guestAdapter.setListener(this)
    }

    private fun loadData() {
       service.getAllGuests(object: ServiceCallback<List<Guest>, Error> {
           override fun success(t: List<Guest>) {
               guestAdapter.setData(t)
               return
           }

           override fun error(u: Error) { }
       })
    }

    private fun getBundle() : Bundle {
        val bundle = Bundle()
        bundle.putParcelable("Guest", guestSelected)
        return bundle
    }

    private fun presentDetailFragment() {
        val fragment = GuestDetailsFragment()
        fragment.arguments = getBundle()
        val transaction: FragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack("list")
        transaction.commit()
    }

    override fun didSelectItem(item: Guest) {
        guestSelected = item
        presentDetailFragment()
    }
}