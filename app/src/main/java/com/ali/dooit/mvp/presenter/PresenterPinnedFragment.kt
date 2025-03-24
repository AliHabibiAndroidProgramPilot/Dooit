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
        // Launching Code On Main Thread With Help Of scope Variable
        scope.launch {
            try {
                // Switches To IO Thread To Operate Database Function
                val pinnedTasks = withContext(Dispatchers.IO) {
                    model.getTasksByState(true)
                }
                view?.initPinnedRecycler(pinnedTasks)
            } catch (e: Exception) {
                Log.e("VIEW_CALLER", e.message!!)
            }
        }
    }

    override fun detachView() {
        this.view = null
        this.job.cancel()
        model.closeDatabase()
    }

}