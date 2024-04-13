package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase6

import com.example.kotlin_coroutines_and_flow.mock.AndroidVersion
import com.example.kotlin_coroutines_and_flow.mock.MockApi
import com.example.kotlin_coroutines_and_flow.mock.VersionFeatures
import com.example.kotlin_coroutines_and_flow.mock.mockAndroidVersions
import com.example.kotlin_coroutines_and_flow.utils.EndpointShouldNotBeCalledException
import kotlinx.coroutines.delay
import java.io.IOException

class FakeSuccessOnThirdAttemptApi(private val responseDelay: Long) : MockApi {

    var requestCount = 0

    override suspend fun getRecentAndroidVersions(): List<AndroidVersion> {
        requestCount++
        delay(responseDelay)
        if (requestCount < 3) {
            throw IOException()
        }
        return mockAndroidVersions
    }

    override suspend fun getAndroidVersionFeatures(apiLevel: Int): VersionFeatures {
        throw EndpointShouldNotBeCalledException()
    }
}