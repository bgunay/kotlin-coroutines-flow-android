package com.example.kotlin_coroutines_and_flow.base

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_coroutines_and_flow.R
import com.example.kotlin_coroutines_and_flow.utils.setGone

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getToolbarTitle(): String

    override fun onStart() {
        super.onStart()
        setToolbarTitle(getToolbarTitle())
        getUpButton().setOnClickListener {
            finish()
        }
    }

    private fun getUpButton(): ImageView = findViewById(R.id.btnToolbarBack)
    private fun getToolbar(): TextView = findViewById(R.id.toolbarTitle)

    fun hideUpButton() {
        getUpButton().setGone()
    }

    private fun setToolbarTitle(toolbarTitle: String) {
        getToolbar().text = toolbarTitle
    }
}