package com.ali.dooit.mvp.ext

interface AllListFragmentContract {

    interface View {

    }

    interface Presenter {

        fun attachView(view: View)

        fun viewCaller() {}

        fun detachView()

    }

    interface Model {

    }

}