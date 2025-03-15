package com.ali.dooit.db.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class TaskSubItems(
    @PrimaryKey(autoGenerate = true) val taskSubItemId: Int,
    @ColumnInfo val taskSubItemTitle: String,
    @ColumnInfo val isTaskSubItemCompleted: Boolean = false
)
