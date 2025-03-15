package com.ali.dooit.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity
data class Task(
    @PrimaryKey(true) val taskId: Int,
    @ColumnInfo val taskTitle: String = "",
    @ColumnInfo val taskLabel: String = "",
    @ColumnInfo val isPinned: Boolean = false,
    @ColumnInfo val isNotificationSet: Boolean = false,
    @ColumnInfo val notificationId: Int? = null,
    @ColumnInfo val notificationTitle: String? = null,
    @ColumnInfo val notificationDataAndTime: Instant? = null,
    @ColumnInfo val isTaskCompleted: Boolean = false
)
