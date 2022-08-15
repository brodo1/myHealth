package com.example.myhealth.reminder.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface UputnicaDao {
    @Insert
    suspend fun insert(uputnicaEntry: UputnicaEntry)

    @Delete
    suspend fun delete(uputnicaEntry: UputnicaEntry)

    @Query("DELETE FROM uputnica_table")
    suspend fun deleteAll()
    @Query("SELECT * FROM uputnica_table")
    fun getAllUputnice(): LiveData<List<UputnicaEntry>>
}