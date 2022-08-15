package com.example.myhealth.reminder.repository

import androidx.lifecycle.LiveData
import com.example.myhealth.reminder.database.UputnicaDao
import com.example.myhealth.reminder.database.UputnicaEntry

class UputnicaRepository(val uputnicaDao: UputnicaDao) {
    suspend fun insert(uputnicaEntry: UputnicaEntry)=uputnicaDao.insert(uputnicaEntry)

    suspend fun deleteItem(uputnicaEntry: UputnicaEntry)=uputnicaDao.delete(uputnicaEntry)
    suspend fun deleteAll(){
        uputnicaDao.deleteAll()
    }

    fun getAllUputnice(): LiveData<List<UputnicaEntry>> = uputnicaDao.getAllUputnice()
}