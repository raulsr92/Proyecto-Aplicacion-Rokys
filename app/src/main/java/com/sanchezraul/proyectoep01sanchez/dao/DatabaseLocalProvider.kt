package com.sanchezraul.proyectoep01sanchez.dao

import android.content.Context
import androidx.room.Room

object DatabaseLocalProvider {

    private var INSTANCE: LocalDatabase? = null

    fun getDatabase(context: Context): LocalDatabase{

        return INSTANCE ?: synchronized(this){

            val newInstance = Room.databaseBuilder(
                context.applicationContext,
                LocalDatabase::class.java,
                "local_database"
            ).build()
            INSTANCE = newInstance
            newInstance
        }
    }
}