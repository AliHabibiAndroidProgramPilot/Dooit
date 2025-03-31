package com.ali.dooit.mvp.ext

import android.content.res.Configuration
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle

interface ActivityUtils {

    fun setFragmentManager(containerId: Int, fragment: Fragment) {}

    fun changeSystemBarsColors() {}

    fun takeFragmentManager(): FragmentManager? { return null }

    fun takeLifecycle(): Lifecycle? { return null }

    fun getResourcesConfiguration(): Configuration? { return null }

    fun getBackPressedDispatchers(): OnBackPressedDispatcher? { return null }

}