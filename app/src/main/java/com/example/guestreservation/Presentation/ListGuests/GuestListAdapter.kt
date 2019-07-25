package com.example.guestreservation.Presentation.ListGuests

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guestreservation.Model.Guest
import com.example.guestreservation.R
import kotlinx.android.synthetic.main.list_guest_row.view.*

class GuestListAdapter(val context: Context): RecyclerView.Adapter<GuestListViewHolder>() {

    private var data: List<Guest> = ArrayList()

    fun setData(data: List<Guest>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GuestListViewHolder {
        return GuestListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_guest_row, p0, false))
    }

    override fun onBindViewHolder(p0: GuestListViewHolder, p1: Int) {
        setViewHolderData(p0,p1)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private fun setViewHolderData(p0: GuestListViewHolder, p1: Int) {
        val guest = data[p1]
        p0.guestName.text = "${guest.firstname} ${guest.lastname}"
        p0.date.text = "${guest.dateFrom} - ${guest.dateTill}"
    }
}

class GuestListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val guestName = itemView.guestNameText
    val date = itemView.date
}
