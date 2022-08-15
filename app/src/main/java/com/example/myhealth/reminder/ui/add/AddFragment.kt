package com.example.myhealth.reminder.ui.add

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentAddBinding
import com.example.myhealth.reminder.database.UputnicaEntry
import com.example.myhealth.reminder.viewmodel.UputnicaViewModel
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment(R.layout.fragment_add) {

    private val viewModel: UputnicaViewModel by viewModels()
    


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentAddBinding.inflate(inflater)

        unosDatuma(binding)
        unosVremena(binding)

        binding.apply {
            buttonSave.setOnClickListener {
                if(TextUtils.isEmpty(unesiUputnicu.text) || TextUtils.isEmpty(unesiVrijeme.text) || TextUtils.isEmpty(unesiDatum.text)){
                    Toast.makeText(requireContext(),"Ispuni sva polja!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener //vrati se opet na listenera
                }
                val naziv= unesiUputnicu.text.toString()
                val datum= unesiDatum.text.toString()
                val vrijeme =unesiVrijeme.text.toString()

                val uputnicaEntry= UputnicaEntry(0, naziv, datum, vrijeme)
                viewModel.insert(uputnicaEntry)
                val action = AddFragmentDirections.actionAddFragmentToReminderFragment3()
                findNavController().navigate(action)
            }
        }

        return binding.root

    }

    private fun unosVremena(binding: FragmentAddBinding) {
        val currTime= Calendar.getInstance()
        val startHour = currTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = currTime.get(Calendar.MINUTE)
        val timePicker = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            binding.unesiVrijeme.setText("$hourOfDay:$minute")
        }
        binding.unesiVrijeme.setOnClickListener {
            TimePickerDialog(requireContext(),timePicker,startHour,startMinute,false).show()
        }

    }

    private fun unosDatuma(binding: FragmentAddBinding) {
        val myCalendar = Calendar.getInstance()
        val formatDate = SimpleDateFormat("dd.MM.YYYY", Locale.GERMAN)
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            binding.unesiDatum.setText(formatDate.format(myCalendar.time))
        }
        binding.unesiDatum.setOnClickListener {
            DatePickerDialog(requireContext(), datePicker,
                myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
            }


    }


}