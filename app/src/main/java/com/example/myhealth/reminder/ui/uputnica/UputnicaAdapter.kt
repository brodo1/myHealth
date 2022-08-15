package com.example.myhealth.reminder.ui.uputnica

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.databinding.RowBinding
import com.example.myhealth.reminder.database.UputnicaEntry

class UputnicaAdapter: androidx.recyclerview.widget.ListAdapter<UputnicaEntry,UputnicaAdapter.ViewHolder>(UputnicaDiffCallback){
    companion object UputnicaDiffCallback : DiffUtil.ItemCallback<UputnicaEntry>(){
        override fun areItemsTheSame(oldItem: UputnicaEntry, newItem: UputnicaEntry)= oldItem.id==newItem.id
        override fun areContentsTheSame(oldItem: UputnicaEntry, newItem: UputnicaEntry)= oldItem==newItem
    }
class ViewHolder( val binding: RowBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(uputnicaEntry: UputnicaEntry){
        binding.uputnicaEntry =uputnicaEntry
        binding.executePendingBindings()
    }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curr=getItem(position)
        holder.bind(curr)
    }


}