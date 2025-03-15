package com.ali.dooit.db

import androidx.room.TypeConverter
import java.time.Instant

class Converters {

    @TypeConverter
    fun timeStampToInstance(value: Long?): Instant? {
        return value?.let { Instant.ofEpochMilli(it) }
    }

    @TypeConverter
    fun instanceToTimeStamp(instant: Instant?): Long? {
        return instant?.toEpochMilli()
    }

}