package com.example.guestreservation.Presentation.AddGuest

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.guestreservation.MainActivity
import com.example.guestreservation.Model.Guest
import com.example.guestreservation.R
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.add_guest_fragment.*
import org.reactivestreams.Subscription
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
        guestDateFromInput.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener
            { _, year, monthOfYear, dayOfMonth ->
                guestDateFromInput.text = "$dayOfMonth.${monthOfYear+1}.$year"
            }, year, month, day)
            datePickerDialog.show()
        }
    }

    private fun setDateTillPicker() {
        val calendar = Calendar.getInstance()
        guestDateTillInput.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener
            { _, year, monthOfYear, dayOfMonth ->
                guestDateTillInput.text = "$dayOfMonth.${monthOfYear+1}.$year"
            }, year, month, day)
            datePickerDialog.show()
        }
    }

    private fun setConfirmBtnClickListener() {
        confirmBtn.setOnClickListener {
            val firstname = guestFirstnameInput.text.toString()
            val lastname = guestLastnameInput.text.toString()
            val dateFrom = guestDateFromInput.text.toString()
            val dateTill = guestDateTillInput.text.toString()
            val didPay = guestDidPaySwitch.isChecked
            var guest = Guest()
            guest.firstname = firstname
            guest.lastname = lastname
            guest.dateFrom = dateFrom
            guest.dateTill = dateTill
            guest.didPay = didPay
            Toast.makeText(context!!, "$firstname, $lastname, $dateFrom, $dateTill, $didPay", Toast.LENGTH_LONG).show()
        }
    }
}