package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase14

import com.example.kotlin_coroutines_and_flow.mock.AndroidVersion
import com.example.kotlin_coroutines_and_flow.mock.MockApi
import com.example.kotlin_coroutines_and_flow.mock.VersionFeatures
import com.example.kotlin_coroutines_and_flow.mock.mockAndroidVersions
import com.example.kotlin_coroutines_and_flow.utils.EndpointShouldNotBeCalledException
import kotlinx.coroutines.delay

class FakeApi : MockApi {

    override suspend fun getRecentAndroidVersions(): List<AndroidVersion> {
        delay(1)
        return mockAndroidVersions
    }

    override suspend fun getAndroidVersionFeatures(apiLevel: Int): VersionFeatures {
        throw EndpointShouldNotBeCalledException()
    }
}