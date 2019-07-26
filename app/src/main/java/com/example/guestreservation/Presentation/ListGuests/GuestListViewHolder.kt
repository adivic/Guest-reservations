package com.example.guestreservation.Presentation.ListGuests

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.list_guest_row.view.*

class GuestListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    interface GuestViewHolderListener {
        fun didSelectRow(position: Int)
    }

    val guestName = itemView.guestNameText
    val date = itemView.date

    lateinit var listener: GuestViewHolderListener

    init {
        itemView.setOnClickListener {
            listener.didSelectRow(adapterPosition)
        }
    }
}