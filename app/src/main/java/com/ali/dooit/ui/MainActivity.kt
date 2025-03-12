package com.ali.dooit.ui

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.dooit.R
import com.ali.dooit.mvp.ext.ActivityUtils
import com.ali.dooit.mvp.model.ModelMainActivity
import com.ali.dooit.mvp.presenter.PresenterMainActivity
import com.ali.dooit.mvp.view.ViewMainActivity

class MainActivity : AppCompatActivity(), ActivityUtils {

    private lateinit var presenter: PresenterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewMainActivity(this, this)
        val model = ModelMainActivity(this)
        presenter = PresenterMainActivity(view, model, this)
        enableEdgeToEdge()
        setContentView(view.binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        presenter.onCreate()
    }

    override fun setFragmentManager() {
        val isLightModeOn: Boolean =
            (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_NO) ==
                    Configuration.UI_MODE_NIGHT_NO
        Log.i("IS_LIGHT_MODE_ON", isLightModeOn.toString())
        if (isLightModeOn) {
            val insetsController = WindowCompat.getInsetsController(window, window.decorView)
            window.statusBarColor = Color.BLACK
            window.navigationBarColor = Color.BLACK
            insetsController.isAppearanceLightNavigationBars = false
            insetsController.isAppearanceLightStatusBars = false
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.welcome_page_container, WelcomePageFragment())
            .commit()
    }

}