package com.ali.dooit.mvp.ext

interface PinnedFragmentContract {

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