package com.sanchezraul.proyectoep01sanchez.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date


@Entity(tableName = "locales")
@TypeConverters(Converters::class)

data class Local (

    @PrimaryKey(autoGenerate = true) val idlocal: Int = 0,
    val namelocal:String,
    val direccionlocal:String,
    val latitud:Double,
    val longitud:Double,
    val telefonolocal:String,

    //@ColumnInfo(name = "created_at") val createdAt: Date = Date()

    )