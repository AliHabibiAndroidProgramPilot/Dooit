package com.ali.dooit.mvp.ext

import androidx.fragment.app.Fragment

interface ActivityUtils {

    fun setFragmentManager(containerId: Int, fragment: Fragment)

    fun changeSystemBarsColors() {}

}