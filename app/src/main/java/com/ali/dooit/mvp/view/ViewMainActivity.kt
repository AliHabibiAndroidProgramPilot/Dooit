package com.ali.dooit.mvp.view

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.ali.dooit.adapter.TabLayoutAdapter
import com.ali.dooit.databinding.ActivityMainBinding
import com.ali.dooit.mvp.ext.ActivityUtils
import com.google.android.material.tabs.TabLayoutMediator

class ViewMainActivity(
    context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, inset ->
            val systemBars = inset.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            inset
        }
    }

    fun setSystemBarsColors() {
        val configuration: Configuration = utils.getResourcesConfiguration()!!
        val isLightModeOn: Boolean =
            (configuration.uiMode and Configuration.UI_MODE_NIGHT_NO) ==
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