package com.example.guestreservation.Presentation.AddGuest

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.guestreservation.Model.Guest
import com.example.guestreservation.R
import kotlinx.android.synthetic.main.add_guest_fragment.*
import java.util.*

class AddGuestFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_guest_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        setDateFromPicker()
        setDateTillPicker()
        setConfirmBtnClickListener()
    }

    private fun setDateFromPicker() {
        val calendar = Calendar.getInstance()
        detailDateFrom.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener
            { _, year, monthOfYear, dayOfMonth ->
                detailDateFrom.text = "$dayOfMonth.${monthOfYear+1}.$year"
            }, year, month, day)
            datePickerDialog.show()
        }
    }

    private fun setDateTillPicker() {
        val calendar = Calendar.getInstance()
        detailDateTill.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener
            { _, year, monthOfYear, dayOfMonth ->
                detailDateTill.text = "$dayOfMonth.${monthOfYear+1}.$year"
            }, year, month, day)
            datePickerDialog.show()
        }
    }

    private fun setConfirmBtnClickListener() {
        confirmBtn.setOnClickListener {
            val firstname = detailFirstname.text.toString()
            val lastname = detailLastname.text.toString()
            val dateFrom = detailDateFrom.text.toString()
            val dateTill = detailDateTill.text.toString()
            val description = detailDescription.text.toString()
            val didPay = detailDidPay.isChecked
            var guest = Guest()
            guest.firstname = firstname
            guest.lastname = lastname
            guest.dateFrom = dateFrom
            guest.dateTill = dateTill
            guest.didPay = didPay
            guest.description = description
            Toast.makeText(context!!, "$firstname, $lastname, $dateFrom, $dateTill, $didPay $description", Toast.LENGTH_LONG).show()
        }
    }
}