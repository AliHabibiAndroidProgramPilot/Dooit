package com.ali.dooit.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ali.dooit.db.AppDataBase
import com.ali.dooit.db.entities.LabelEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LabelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLabel(vararg label: LabelEntity)

    @get:Query("SELECT * FROM ${AppDataBase.LABEL_TABLE_NAME}")
    val labels: Flow<List<LabelEntity>>

    @Delete
    suspend fun deleteLabel(vararg label: LabelEntity)

}