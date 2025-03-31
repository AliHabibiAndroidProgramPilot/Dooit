package com.ali.dooit.mvp.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ali.dooit.R
import com.ali.dooit.databinding.ActivityAddTaskBinding
import com.ali.dooit.mvp.ext.ActivityUtils
import com.google.android.material.textfield.TextInputEditText

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

    fun navigationBackClickHandler() {
        binding.icNavigationBack.setOnClickListener {
            utils.getBackPressedDispatchers()!!.onBackPressed()
        }
    }

    fun emptyTaskTitleController() {
        val saveIcon: ImageButton = binding.btnSave
        val title: TextInputEditText = binding.edtTaskTitle
        title.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                if (text.isNullOrEmpty()) {
                    saveIcon.isEnabled = false
                    saveIcon.isClickable = false
                    saveIcon.alpha = 0.5f
                } else {
                    saveIcon.isEnabled = true
                    saveIcon.isClickable = true
                    saveIcon.alpha = 1f
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
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