package com.example.myhealth.reminder.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.sql.Date
import java.sql.Time
@Parcelize
@Entity(tableName = "uputnica_table")
data class UputnicaEntry (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var naslov: String,
    var datum: String,
    var vrijeme: String
    ):Parcelable

