package com.ali.dooit.mvp.ext

import com.ali.dooit.db.entities.relations.TaskWithTaskSubItems

interface PinnedFragmentContract {

    interface View {

        fun initPinnedRecycler(pinnedTasks: ArrayList<TaskWithTaskSubItems>)

    }

    interface Presenter {

        fun attachView(view: View)

        fun viewCaller() {}

        fun detachView()

    }

    interface Model {

        suspend fun getPinnedTasks(): ArrayList<TaskWithTaskSubItems>

        fun closeDatabase()

    }

}