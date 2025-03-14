package com.ali.dooit.mvp.presenter

import com.ali.dooit.mvp.ext.PinnedFragmentContract

class PresenterPinnedFragment(
    private val model: PinnedFragmentContract.Model
) : PinnedFragmentContract.Presenter {

    private var view: PinnedFragmentContract.View? = null

    override fun attachView(view: PinnedFragmentContract.View) {
        this.view = view
    }

    override fun viewCaller() {

    }

    override fun detachView() {
        this.view = null
    }

}