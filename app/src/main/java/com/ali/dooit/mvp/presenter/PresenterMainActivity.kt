package com.ali.dooit.mvp.presenter

import com.ali.dooit.R
import com.ali.dooit.mvp.ext.ActivityLifecycle
import com.ali.dooit.mvp.ext.ActivityUtils
import com.ali.dooit.mvp.model.ModelMainActivity
import com.ali.dooit.mvp.view.ViewMainActivity
import com.ali.dooit.ui.WelcomePageFragment

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity,
    private val utils: ActivityUtils
) : ActivityLifecycle {

    override fun onCreate() {
        setWelcomePageFragment()
        initializeTabLayout()
    }

    private fun setWelcomePageFragment() {
        if (checkAppRunState()) {
            systemBarsColors()
            utils.setFragmentManager(R.id.welcome_page_container, WelcomePageFragment())
        }
    }

    private fun initializeTabLayout() {
        view.initializeTabLayout()
    }

    private fun systemBarsColors() {
        view.setSystemBarsColors()
    }

    private fun checkAppRunState(): Boolean {
        val isFirstRun = model.saveAppRunState()
        model.changeAppRunState()
        return isFirstRun
    }

}