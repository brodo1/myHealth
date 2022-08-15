package com.example.myhealth.reminder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentReminderBinding
import com.example.myhealth.reminder.ui.uputnica.UputnicaAdapter
import com.example.myhealth.reminder.viewmodel.UputnicaViewModel


class reminderFragment:Fragment(R.layout.fragment_reminder){

    private val viewModel:UputnicaViewModel by viewModels()
    private lateinit var adapter: UputnicaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentReminderBinding.inflate(inflater)

        binding.lifecycleOwner=this
        binding.viewModel=viewModel

        adapter= UputnicaAdapter()

        viewModel.getAllUputnice.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        binding.apply {

            binding.recyclerView.adapter=adapter

            floatingActionButton.setOnClickListener {
                val action = reminderFragmentDirections.actionReminderFragment3ToAddFragment()
                findNavController().navigate(action)
            }
        }

        return binding.root
    }

}

/*
class reminderFragment : Fragment(R.layout.fragment_reminder) {

    private val viewModel: UputnicaViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val bindingImpl=FragmentReminderBinding.inflate(inflater).apply {
            floatingActionButton.setOnClickListener {
                Toast.makeText(requireActivity(),"PRESSED",Toast.LENGTH_SHORT).show()
                // findNavController().navigate(R.id.action_reminderFragment_to_addFragment)
            }
        }

        return bindingImpl.root
    }


}
*/
