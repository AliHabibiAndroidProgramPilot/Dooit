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
import kotlinx.coroutines.flow.Flow
import java.time.Instant

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg task: TaskEntity)

    @Transaction
    @Query("SELECT * FROM ${AppDataBase.TASK_TABLE_NAME} WHERE isPinned = :isPinned")
    fun getTasksByState(isPinned: Boolean): Flow<List<TaskEntity>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(vararg task: TaskEntity)

    /**@get:Query("SELECT taskLabel FROM ${AppDataBase.TASK_TABLE_NAME}")
    val taskLabel: String*/

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