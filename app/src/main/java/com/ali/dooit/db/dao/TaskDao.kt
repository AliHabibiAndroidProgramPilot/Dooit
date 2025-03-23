package com.ali.dooit.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.ali.dooit.db.AppDataBase
import com.ali.dooit.db.entities.TaskEntity
import com.ali.dooit.db.entities.TaskSubItemsEntity
import com.ali.dooit.db.entities.relations.TaskWithTaskSubItems
import kotlinx.coroutines.flow.Flow
import java.time.Instant

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg task: TaskEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskSubItems(subItems: List<TaskSubItemsEntity>)

    @Transaction
    @Query("SELECT * FROM ${AppDataBase.TASK_TABLE_NAME} WHERE isPinned = :isPinned")
    suspend fun getAllTasksByState(isPinned: Boolean): List<TaskWithTaskSubItems> // Get all tasks with their sub-items

    @Transaction
    @Query("SELECT * FROM ${AppDataBase.TASK_TABLE_NAME} WHERE taskId = :taskId AND isPinned = :isPinned")
    suspend fun getTask(
        taskId: Int,
        isPinned: Boolean
    ): TaskWithTaskSubItems?  // Get a specific task with their sub-items

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(vararg task: TaskEntity)

    @get:Query("SELECT taskLabel FROM ${AppDataBase.TASK_TABLE_NAME}")
    val taskLabels: Flow<List<String>>

    @Query(
        "UPDATE ${AppDataBase.TASK_TABLE_NAME} SET " +
                "isNotificationSet = :isNotificationSet, " +
                "notificationId = :notificationId, " +
                "notificationTitle = :notificationTitle, " +
                "notificationDataAndTime = :notificationDateAndTime " +
                "WHERE taskId = :taskId"
    )
    suspend fun updateTaskNotificationState(
        taskId: Int,
        isNotificationSet: Boolean,
        notificationId: Int,
        notificationTitle: String,
        notificationDateAndTime: Instant
    )

    @Delete
    suspend fun delete(vararg task: TaskEntity)

}