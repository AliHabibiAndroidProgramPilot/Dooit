package com.ali.dooit.mvp.presenter

import com.ali.dooit.mvp.ext.ActivityLifecycle
import com.ali.dooit.mvp.ext.ActivityUtils
import com.ali.dooit.mvp.model.ModelAddTaskActivity
import com.ali.dooit.mvp.view.ViewAddTaskActivity

class PresenterAddTaskActivity(
    private val view: ViewAddTaskActivity,
    private val model: ModelAddTaskActivity,
    private val utils: ActivityUtils
) : ActivityLifecycle {

    override fun onCreate() {
        onApplyWindowInsets()
        pinTaskOnClick()
        navigationBackOnClick()
        taskTitleController()
    }

    private fun onApplyWindowInsets() {
        view.applyWindowInsets()
    }

    private fun pinTaskOnClick() {
        view.pinTaskClickHandler()
    }

    private fun navigationBackOnClick() {
        view.navigationBackClickHandler()
    }

    private fun taskTitleController() {
        view.emptyTaskTitleController()
    }

}