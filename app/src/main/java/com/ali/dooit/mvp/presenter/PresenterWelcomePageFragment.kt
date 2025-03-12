package com.ali.dooit.mvp.presenter

import com.ali.dooit.mvp.ext.WelcomePageView

class PresenterWelcomePageFragment(private val utils: WelcomePageView) {

    fun onContinueButtonClicked() {
        utils.removeFragment()
    }

    fun setBackSystemBarsColors() {
        utils.setSystemBarsColors()
    }

}