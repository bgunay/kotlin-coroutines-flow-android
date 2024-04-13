package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase3

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.kotlin_coroutines_and_flow.R
import com.example.kotlin_coroutines_and_flow.base.BaseActivity
import com.example.kotlin_coroutines_and_flow.base.useCase3Description
import com.example.kotlin_coroutines_and_flow.databinding.ActivityPerformnetworkrequestsconcurrentlyBinding
import com.example.kotlin_coroutines_and_flow.utils.fromHtml
import com.example.kotlin_coroutines_and_flow.utils.setGone
import com.example.kotlin_coroutines_and_flow.utils.setVisible
import com.example.kotlin_coroutines_and_flow.utils.toast

class PerformNetworkRequestsConcurrentlyActivity : BaseActivity() {

    private val binding by lazy {
        ActivityPerformnetworkrequestsconcurrentlyBinding.inflate(
            layoutInflater
        )
    }

    private val viewModel: PerformNetworkRequestsConcurrentlyViewModel by viewModels()
    override fun getToolbarTitle() = useCase3Description

    private var operationStartTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.uiState().observe(this, Observer { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        })
        binding.btnRequestsSequentially.setOnClickListener {
            viewModel.performNetworkRequestsSequentially()
        }
        binding.btnRequestsConcurrently.setOnClickListener {
            viewModel.performNetworkRequestsConcurrently()
        }
    }

    private fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                onLoad()
            }
            is UiState.Success -> {
                onSuccess(uiState)
            }
            is UiState.Error -> {
                onError(uiState)
            }
        }
    }

    private fun onLoad() = with(binding) {
        operationStartTime = System.currentTimeMillis()
        progressBar.setVisible()
        textViewDuration.text = ""
        textViewResult.text = ""
        disableButtons()
    }

    private fun onSuccess(uiState: UiState.Success) = with(binding) {
        enableButtons()
        progressBar.setGone()
        val duration = System.currentTimeMillis() - operationStartTime
        textViewDuration.text = getString(R.string.duration, duration)

        val versionFeatures = uiState.versionFeatures
        val versionFeaturesString = versionFeatures.joinToString(separator = "<br><br>") {
            "<b>New Features of ${it.androidVersion.name} </b> <br> ${it.features.joinToString(
                prefix = "- ",
                separator = "<br>- "
            )}"
        }

        textViewResult.text = fromHtml(versionFeaturesString)
    }

    private fun onError(uiState: UiState.Error) {
        binding.progressBar.setGone()
        binding.textViewDuration.setGone()
        toast(uiState.message)
        enableButtons()
    }

    private fun enableButtons() {
        binding.btnRequestsSequentially.isEnabled = true
        binding.btnRequestsConcurrently.isEnabled = true
    }

    private fun disableButtons() {
        binding.btnRequestsSequentially.isEnabled = false
        binding.btnRequestsConcurrently.isEnabled = false
    }
}