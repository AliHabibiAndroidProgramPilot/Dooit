package com.ali.dooit.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.ali.dooit.db.entities.Label
import com.ali.dooit.db.entities.Task

data class LabelWithTasks(
    @Embedded val label: Label,
    @Relation(parentColumn = "label", entityColumn = "taskLabel")
    val tasks: List<Task>
)