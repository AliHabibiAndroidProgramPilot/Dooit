package com.ali.dooit.db.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.ali.dooit.db.entities.LabelEntity
import com.ali.dooit.db.entities.TaskEntity

data class TasksWithLabel(
    @Embedded val task: TaskEntity,
    @Relation(parentColumn = "taskLabel", entityColumn = "label")
    val labels: List<LabelEntity>
)