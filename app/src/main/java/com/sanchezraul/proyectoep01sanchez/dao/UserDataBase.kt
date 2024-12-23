package com.sanchezraul.proyectoep01sanchez.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)


abstract class UserDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

}