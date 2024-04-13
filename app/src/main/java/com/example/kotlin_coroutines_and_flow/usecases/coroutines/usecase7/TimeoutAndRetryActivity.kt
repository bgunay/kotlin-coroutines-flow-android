package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase7

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.kotlin_coroutines_and_flow.base.BaseActivity
import com.example.kotlin_coroutines_and_flow.base.useCase7Description
import com.example.kotlin_coroutines_and_flow.databinding.ActivityRetrynetworkrequestBinding
import com.example.kotlin_coroutines_and_flow.utils.fromHtml
import com.example.kotlin_coroutines_and_flow.utils.setGone
import com.example.kotlin_coroutines_and_flow.utils.setVisible
import com.example.kotlin_coroutines_and_flow.utils.toast

class TimeoutAndRetryActivity : BaseActivity() {

    override fun getToolbarTitle() = useCase7Description

    private val binding by lazy { ActivityRetrynetworkrequestBinding.inflate(layoutInflater) }
    private val viewModel: TimeoutAndRetryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.uiState().observe(this, Observer { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        })
        binding.btnPerformSingleNetworkRequest.setOnClickListener {
            viewModel.performNetworkRequest()
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
        progressBar.setVisible()
        textViewResult.text = ""
        btnPerformSingleNetworkRequest.isEnabled = false
    }

    private fun onSuccess(uiState: UiState.Success) = with(binding) {
        progressBar.setGone()
        btnPerformSingleNetworkRequest.isEnabled = true

        val versionFeatures = uiState.versionFeatures
        val versionFeaturesString = versionFeatures.map {
            "<b>New Features of ${it.androidVersion.name} </b> <br> ${it.features.joinToString(
                prefix = "- ",
                separator = "<br>- "
            )}"
        }.joinToString(separator = "<br><br>")

        textViewResult.text = fromHtml(versionFeaturesString)
    }

    private fun onError(uiState: UiState.Error) = with(binding) {
        progressBar.setGone()
        btnPerformSingleNetworkRequest.isEnabled = true
        toast(uiState.message)
    }
}