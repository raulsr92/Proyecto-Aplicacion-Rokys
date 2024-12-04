package com.sanchezraul.proyectoep01sanchez.dao

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Local::class], version = 1, exportSchema = false)

abstract class LocalDatabase: RoomDatabase() {

    abstract fun localDao(): LocalDao

}