package com.ali.dooit.ui

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ali.dooit.R
import com.ali.dooit.db.AppDataBase
import com.ali.dooit.mvp.ext.ActivityUtils
import com.ali.dooit.mvp.model.ModelMainActivity
import com.ali.dooit.mvp.presenter.PresenterMainActivity
import com.ali.dooit.mvp.view.ViewMainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    override fun setFragmentManager(containerId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }

    override fun changeSystemBarsColors() {
        val insetsController = WindowCompat.getInsetsController(window, window.decorView)
        window.statusBarColor = Color.BLACK
        window.navigationBarColor = Color.BLACK
        insetsController.isAppearanceLightNavigationBars = false
        insetsController.isAppearanceLightStatusBars = false
    }

    override fun takeFragmentManager() = supportFragmentManager

    override fun takeLifecycle() = lifecycle

}