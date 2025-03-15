package com.ali.dooit.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ali.dooit.db.AppDataBase

@Entity(tableName = AppDataBase.TASK_SUB_ITEM_TABLE_NAME)
data class TaskSubItemsEntity(
    @PrimaryKey(autoGenerate = true) val taskSubItemId: Int,
    @ColumnInfo val taskSubItemTitle: String,
    @ColumnInfo val isTaskSubItemCompleted: Boolean = false
)
