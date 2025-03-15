package com.ali.dooit.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.ali.dooit.db.entities.Label
import com.ali.dooit.db.entities.Task

data class TasksWithLabel(
    @Embedded val task: Task,
    @Relation(parentColumn = "taskLabel", entityColumn = "label")
    val labels: List<Label>
)