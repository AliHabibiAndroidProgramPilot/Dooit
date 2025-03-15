package com.ali.dooit.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ali.dooit.db.AppDataBase

@Entity(tableName = AppDataBase.LABEL_TABLE_NAME)
data class LabelEntity(
    @PrimaryKey(autoGenerate = false) val label: String
)
