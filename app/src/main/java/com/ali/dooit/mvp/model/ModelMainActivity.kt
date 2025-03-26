package com.ali.dooit.mvp.model

import android.content.Context

class ModelMainActivity(context: Context) {

    private val sharedPreferencesTag = "isFirstRun"
    private val sharedPreferences =
        context.getSharedPreferences(sharedPreferencesTag, Context.MODE_PRIVATE)

    fun saveAppRunState(): Boolean =
        sharedPreferences.getBoolean(sharedPreferencesTag, true)

    fun changeAppRunState() {
        sharedPreferences.edit()
            .putBoolean(sharedPreferencesTag, false)
            .apply()
    }

}