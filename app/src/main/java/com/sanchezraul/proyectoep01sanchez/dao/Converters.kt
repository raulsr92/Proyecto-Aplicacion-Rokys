package com.sanchezraul.proyectoep01sanchez.dao

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun fromTmeStamp(value: Long?): Date?{
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long?{
        return date?.time
    }
}