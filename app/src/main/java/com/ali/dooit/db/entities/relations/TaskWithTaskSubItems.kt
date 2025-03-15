package com.ali.dooit.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.ali.dooit.db.entities.TaskEntity
import com.ali.dooit.db.entities.TaskSubItemsEntity

data class TaskWithTaskSubItems(
    @Embedded val task: TaskEntity,
    @Relation(parentColumn = "taskId", entityColumn = "taskSubItemTitle")
    val taskSubItems: List<TaskSubItemsEntity>
)
