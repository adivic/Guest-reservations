package com.example.guestreservation.Presentation.ListGuests

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.example.guestreservation.MainActivity
import com.example.guestreservation.Model.Guest
import com.example.guestreservation.R
import com.example.guestreservation.showBackButton
import kotlinx.android.synthetic.main.guest_details.*

class GuestDetailsFragment : Fragment() {

    private var guest: Guest? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.guest_details, container, false)
    }

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        guest = args?.getParcelable("Guest")
    }

    override fun onStart() {
        super.onStart()
        setDetailsData()
        showBackButton()
    }

    private fun showBackButton() {
        (activity as MainActivity).showBackButton()
    }

    private fun setDetailsData() {
        detailFirstname.text = guest?.firstname
        detailLastname.text = guest?.lastname
        detailDateFrom.text = guest?.dateFrom
        detailDateTill.text = guest?.dateTill
        detailDidPay.isChecked = guest?.didPay ?: false
        detailDescription.text = guest?.description
    }
}