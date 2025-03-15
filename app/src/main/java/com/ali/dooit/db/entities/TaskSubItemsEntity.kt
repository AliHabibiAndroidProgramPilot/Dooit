package com.ali.dooit.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ali.dooit.db.AppDataBase

@Entity(
    tableName = AppDataBase.TASK_SUB_ITEM_TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = TaskEntity::class,
        parentColumns = ["taskId"],
        childColumns = ["taskOwnerId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["taskOwnerId"])]
)
data class TaskSubItemsEntity(
    @PrimaryKey(autoGenerate = true) val taskSubitem: Int = 0,
    @ColumnInfo val taskOwnerId: Int, // Foreign key referencing TaskEntity.taskId
    @ColumnInfo val taskSubItemTitle: String,
    @ColumnInfo val isTaskSubItemCompleted: Boolean
)
