package com.ali.dooit.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.ali.dooit.db.entities.TaskSubItemsEntity

@Dao
interface TaskSubItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskSubItem(vararg: TaskSubItemsEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTaskSubitem(vararg taskSubItem: TaskSubItemsEntity)

    @Delete
    suspend fun deleteTaskSubItem(vararg taskSubItem: TaskSubItemsEntity)

}