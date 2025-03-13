package com.ali.dooit.mvp.view

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.ali.dooit.adapter.TabLayoutAdapter
import com.ali.dooit.databinding.ActivityMainBinding
import com.ali.dooit.mvp.ext.ActivityUtils
import com.google.android.material.tabs.TabLayoutMediator

class ViewMainActivity : FrameLayout {

    private lateinit var utils: ActivityUtils

    constructor(contextInstance: Context) : super(contextInstance)
    constructor(contextInstance: Context, activityUtils: ActivityUtils) : super(contextInstance) {
        utils = activityUtils
    }

    val binding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun setSystemBarsColors() {
        val isLightModeOn: Boolean =
            (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_NO) ==
                    Configuration.UI_MODE_NIGHT_NO
        Log.i("IS_LIGHT_MODE_ON", isLightModeOn.toString())
        if (isLightModeOn) {
            utils.changeSystemBarsColors()
        }
    }

    fun initializeTabLayout() {
        val tabLayoutTitles = listOf("All List", "Pinned")
        val fragmentManager: FragmentManager = utils.takeFragmentManager()!!
        val lifecycle: Lifecycle = utils.takeLifecycle()!!
        binding.tabLayoutViewPager.adapter = TabLayoutAdapter(fragmentManager, lifecycle)
        binding.tabLayoutViewPager.isUserInputEnabled = false
        TabLayoutMediator(binding.mainTabLayout, binding.tabLayoutViewPager) { tab, position ->
            tab.text = tabLayoutTitles[position]
        }.attach()
    }

}