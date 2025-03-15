package com.ali.dooit.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ali.dooit.db.AppDataBase
import java.time.Instant

@Entity(tableName = AppDataBase.TASK_TABLE_NAME)
data class TaskEntity(
    @PrimaryKey(true) val taskId: Int,
    @ColumnInfo val taskTitle: String,
    @ColumnInfo val taskLabel: String = "",
    @ColumnInfo val isPinned: Boolean = false,
    @ColumnInfo val isNotificationSet: Boolean = false,
    @ColumnInfo val notificationId: Int? = null,
    @ColumnInfo val notificationTitle: String? = null,
    @ColumnInfo val notificationDataAndTime: Instant? = null,
    @ColumnInfo val isTaskCompleted: Boolean = false
)
