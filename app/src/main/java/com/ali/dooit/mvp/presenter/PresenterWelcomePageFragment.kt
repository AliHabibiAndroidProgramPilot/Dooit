package com.ali.dooit.mvp.presenter

import com.ali.dooit.mvp.ext.WelcomePageView

class PresenterWelcomePageFragment(private val view: WelcomePageView) {

    fun onContinueButtonClicked() {
        view.removeFragment()
    }

}