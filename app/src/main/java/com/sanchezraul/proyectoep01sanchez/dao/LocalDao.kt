package com.sanchezraul.proyectoep01sanchez.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalDao {
    @Insert
    suspend fun insertLocal(local: Local)

    @Update
    suspend fun updateLocal(local: Local)

    @Delete
    suspend fun deleteLocal(local: Local)


    @Query("SELECT * FROM locales")
     fun getAllLocales() : Flow<List<Local>>
}