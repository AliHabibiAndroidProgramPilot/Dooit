package com.ali.dooit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ali.dooit.db.dao.TaskDao
import com.ali.dooit.db.entities.TaskEntity
import com.ali.dooit.db.entities.TaskSubItemsEntity

@Database(
    entities = [TaskEntity::class, TaskSubItemsEntity::class],
    version = AppDataBase.DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    companion object {

        private const val DATABASE_NAME = "Dooit_DataBase"
        const val DATABASE_VERSION = 1
        const val TASK_TABLE_NAME = "Task"
        const val TASK_SUB_ITEM_TABLE_NAME = "Task_Sub_Items"
        const val LABEL_TABLE_NAME = "Label"
        private var instance: AppDataBase? = null
        fun getDatabaseInstance(context: Context): AppDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                return instance!!
            } else
                return instance!!
        }

    }

    abstract fun taskDao(): TaskDao

}