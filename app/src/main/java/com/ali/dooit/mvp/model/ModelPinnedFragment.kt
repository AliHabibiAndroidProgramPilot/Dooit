package com.ali.dooit.mvp.model

import android.content.Context
import com.ali.dooit.db.AppDataBase
import com.ali.dooit.db.entities.relations.TaskWithTaskSubItems
import com.ali.dooit.mvp.ext.PinnedFragmentContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ModelPinnedFragment(context: Context) : PinnedFragmentContract.Model {

    private val database = AppDataBase.getDatabaseInstance(context)

    override suspend fun getTasksByState(isPinned: Boolean): ArrayList<TaskWithTaskSubItems> {
        return withContext(Dispatchers.IO) {
            val collection = database.taskDao().getAllTasksByState(isPinned)
            ArrayList(collection)
        }
    }

    override fun closeDatabase() {
        if (database.isOpen)
            database.close()
    }

}