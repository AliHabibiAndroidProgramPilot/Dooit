package com.ali.dooit.mvp.presenter

import com.ali.dooit.mvp.ext.AllListFragmentContract

class PresenterAllListFragment(
    private val model: AllListFragmentContract.Model
) : AllListFragmentContract.Presenter {

    private var view: AllListFragmentContract.View? = null

    override fun attachView(view: AllListFragmentContract.View) {
        this.view = view
    }

    override fun viewCaller() {

    }

    override fun detachView() {
        this.view = null
    }

}