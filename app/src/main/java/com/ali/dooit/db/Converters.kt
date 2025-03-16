package com.ali.dooit.db

import androidx.room.TypeConverter
import java.time.Instant

class Converters {

    // For Code Usage
    @TypeConverter
    fun timeStampToInstance(value: Long?): Instant? {
        return value?.let { Instant.ofEpochMilli(it) }
    }

    // For Database Saving
    @TypeConverter
    fun instanceToTimeStamp(instant: Instant?): Long? {
        return instant?.toEpochMilli()
    }

}