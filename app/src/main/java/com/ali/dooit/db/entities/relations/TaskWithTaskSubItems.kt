package com.ali.dooit.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.ali.dooit.db.entities.Task
import com.ali.dooit.db.entities.TaskSubItems

data class TaskWithTaskSubItems(
    @Embedded val task: Task,
    @Relation(parentColumn = "taskId", entityColumn = "taskSubItemTitle")
    val taskSubItems: List<TaskSubItems>
)
