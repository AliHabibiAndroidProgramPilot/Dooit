package com.ali.dooit.ui

import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ali.dooit.mvp.ext.ActivityUtils
import com.ali.dooit.mvp.model.ModelAddTaskActivity
import com.ali.dooit.mvp.presenter.PresenterAddTaskActivity
import com.ali.dooit.mvp.view.ViewAddTaskActivity

class AddTaskActivity : AppCompatActivity(), ActivityUtils {

    private lateinit var presenter: PresenterAddTaskActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewAddTaskActivity(this, this)
        val model = ModelAddTaskActivity(this)
        presenter = PresenterAddTaskActivity(view, model, this)
        enableEdgeToEdge()
        setContentView(view.binding.root)
        presenter.onCreate()
    }

    override fun getBackPressedDispatchers(): OnBackPressedDispatcher = onBackPressedDispatcher

}