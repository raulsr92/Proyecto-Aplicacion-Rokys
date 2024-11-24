package com.sanchezraul.proyectoep01sanchez.dao

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private var INSTANCE: UserDataBase? = null

    fun getDatabase(context: Context): UserDataBase{

        return INSTANCE ?: synchronized(this){

            val newInstance = Room.databaseBuilder(
                context.applicationContext,
                UserDataBase::class.java,
                "user_database"
            ).build()
            INSTANCE = newInstance
            newInstance
        }
    }

}