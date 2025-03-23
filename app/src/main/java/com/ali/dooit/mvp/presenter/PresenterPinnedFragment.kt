package com.ali.dooit.mvp.presenter

import android.util.Log
import com.ali.dooit.mvp.ext.PinnedFragmentContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PresenterPinnedFragment(
    private val model: PinnedFragmentContract.Model
) : PinnedFragmentContract.Presenter {

    private var view: PinnedFragmentContract.View? = null
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    override fun attachView(view: PinnedFragmentContract.View) {
        this.view = view
    }

    override fun viewCaller() {
        try {
            scope.launch {
                val pinnedTasks = withContext(Dispatchers.IO) {
                    model.getPinnedTasks()
                }
                view?.initPinnedRecycler(pinnedTasks)
            }
        } catch (e: Exception) {
            Log.e("VIEW_CALLER", e.message!!)
        }
    }

    override fun detachView() {
        this.view = null
        this.job.cancel()
        model.closeDatabase()
    }

}