package com.example.guestreservation.Presentation.ListGuests

import android.annotation.SuppressLint
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
import com.example.guestreservation.Services.GuestService
import com.example.guestreservation.hideBackButton
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.list_guest_fragment.*
import org.koin.android.ext.android.inject

class GuestListFragment : Fragment(), GuestListAdapter.GuestListAdapterListener {

    private lateinit var guestAdapter: GuestListAdapter
    private val service: GuestService by inject()
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
        hideBackButton()
    }

    private fun hideBackButton() {
        (activity!! as MainActivity).hideBackButton()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context!!)
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

    @SuppressLint("CheckResult")
    private fun loadData() {
        service.getGuest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({guestAdapter.setData(it)}, {})
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