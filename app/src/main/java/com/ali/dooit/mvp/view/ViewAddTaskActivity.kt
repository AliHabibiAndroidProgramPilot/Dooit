package com.ali.dooit.mvp.view

import android.content.Context
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.dooit.databinding.ActivityAddTaskBinding
import com.ali.dooit.mvp.ext.ActivityUtils

class ViewAddTaskActivity(
    private val context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityAddTaskBinding = ActivityAddTaskBinding.inflate(LayoutInflater.from(context))

    fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, inset ->
            val systemBars = inset.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            inset
        }
    }

}