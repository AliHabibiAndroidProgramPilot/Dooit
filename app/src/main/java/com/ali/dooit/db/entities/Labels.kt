package com.ali.dooit.db.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Labels(
    @PrimaryKey(autoGenerate = true) val labelId: Int,
    @ColumnInfo val label: String
)
