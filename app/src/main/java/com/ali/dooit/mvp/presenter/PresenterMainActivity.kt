package com.ali.dooit.mvp.presenter

import com.ali.dooit.mvp.ext.ActivityLifecycle
import com.ali.dooit.mvp.model.ModelMainActivity
import com.ali.dooit.mvp.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity
) : ActivityLifecycle {

    override fun onCreate() {

    }

}