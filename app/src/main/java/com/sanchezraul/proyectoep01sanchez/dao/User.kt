package com.sanchezraul.proyectoep01sanchez.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date


@Entity(tableName = "users")
@TypeConverters(Converters::class)

data class User (

    @PrimaryKey(autoGenerate = true) val idroom: Int = 0,
    val nameroom:String,
    val lastnameroom:String,
    val emailroom:String,
    val telefonoroom:String,
    val passwordroom:String,
    val dniroom:String,

    @ColumnInfo(name = "created_at") val createdAt: Date = Date()

)