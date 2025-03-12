package com.ali.dooit.mvp.view

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.ali.dooit.databinding.ActivityMainBinding
import com.ali.dooit.mvp.ext.ActivityUtils

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

}