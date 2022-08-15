package com.example.myhealth.reminder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(UputnicaEntry::class),version = 1,exportSchema = false)
abstract class UputnicaDataBase: RoomDatabase() {
    abstract fun uputnicaDao(): UputnicaDao

    companion object {
        @Volatile
        private var INSTANCE: UputnicaDataBase?=null

        fun getDataBase(context:Context):UputnicaDataBase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance=Room.databaseBuilder(context.applicationContext,
                    UputnicaDataBase::class.java,
                    "uputnica_database").fallbackToDestructiveMigration().build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}