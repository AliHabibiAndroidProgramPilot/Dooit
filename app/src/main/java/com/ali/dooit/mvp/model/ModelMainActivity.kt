package com.ali.dooit.mvp.model

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class ModelMainActivity(private val activity: AppCompatActivity) {

    private val sharedPreferencesTag = "isFirstRun"
    private val sharedPreferences =
        activity.getSharedPreferences(sharedPreferencesTag, Context.MODE_PRIVATE)

    fun saveAppRunState(): Boolean =
        sharedPreferences.getBoolean(sharedPreferencesTag, true)

    fun changeAppRunState() {
        sharedPreferences.edit()
            .putBoolean(sharedPreferencesTag, false)
            .apply()
    }

}