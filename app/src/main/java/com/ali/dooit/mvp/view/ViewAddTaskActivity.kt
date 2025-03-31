package com.ali.dooit.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.dooit.R
import com.ali.dooit.databinding.ActivityAddTaskBinding
import com.ali.dooit.mvp.ext.ActivityUtils

class ViewAddTaskActivity(
    private val context: Context,
    private val utils: ActivityUtils
) {

    val binding: ActivityAddTaskBinding =
        ActivityAddTaskBinding.inflate(LayoutInflater.from(context))

    fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, inset ->
            val systemBars = inset.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            inset
        }
    }

    fun pinTaskClickHandler() {
        var pinState = false
        val pinStateText = binding.txtPinState
        pinStateText.setOnClickListener {
            when (pinState) {
                true -> {
                    pinStateText.setTextColor(ContextCompat.getColor(context, R.color.black))
                    pinStateText.setTextWithFade("Pin")
                    pinStateText.setBackgroundResource(R.drawable.btn_pinned_bg_not_active)
                    pinState = false
                }

                false -> {
                    pinStateText.setTextColor(ContextCompat.getColor(context, R.color.white))
                    pinStateText.setTextWithFade("Pinned")
                    pinStateText.setBackgroundResource(R.drawable.btn_pinned_bg_active)
                    pinState = true
                }
            }
        }
    }

    private fun TextView.setTextWithFade(text: String) {
        this.animate()
            .alpha(0f)  // Fade out
            .setDuration(200)
            .withEndAction {
                this.text = text // Change text
                this.animate()
                    .alpha(1f)  // Fade in
                    .setDuration(200)
                    .start()
            }.start()
    }

}