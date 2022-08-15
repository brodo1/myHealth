package com.example.myhealth.reminder.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhealth.reminder.database.UputnicaDataBase
import com.example.myhealth.reminder.database.UputnicaEntry
import com.example.myhealth.reminder.repository.UputnicaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UputnicaViewModel(application: Application) :AndroidViewModel(application) {
    private val uputnicaDao=UputnicaDataBase.getDataBase(application).uputnicaDao()
    private val repository : UputnicaRepository
    val getAllUputnice: LiveData<List<UputnicaEntry>>
    init{
        repository = UputnicaRepository(uputnicaDao)
        getAllUputnice=repository.getAllUputnice()
    }
    fun insert(uputnicaEntry: UputnicaEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(uputnicaEntry)
        }
    }

    fun delete(uputnicaEntry: UputnicaEntry){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteItem(uputnicaEntry)
        }
    }
    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAll()
        }
    }
}