package com.ali.dooit.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.ali.dooit.databinding.ActivityMainBinding

class ViewMainActivity(contextInstance: Context) : FrameLayout(contextInstance) {

    val binding: ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(context))

}