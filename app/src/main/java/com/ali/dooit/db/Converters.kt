package com.ali.dooit.db

import androidx.room.TypeConverter
import java.time.Instant

class Converters {

    // For Code Usage (database passes to us)
    @TypeConverter
    fun timeStampToInstance(value: Long?): Instant? {
        return value?.let { Instant.ofEpochMilli(it) }
    }

    // For Database Saving (pass to database)
    @TypeConverter
    fun instanceToTimeStamp(instant: Instant?): Long? {
        return instant?.toEpochMilli()
    }

}