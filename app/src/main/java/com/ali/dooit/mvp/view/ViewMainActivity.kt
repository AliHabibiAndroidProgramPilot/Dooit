package com.ali.dooit.mvp.view

import android.content.Context
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

}