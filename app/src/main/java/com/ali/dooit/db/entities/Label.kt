package com.ali.dooit.db.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Label(
    @PrimaryKey(autoGenerate = false) val label: String
)
