package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase1

import com.example.kotlin_coroutines_and_flow.mock.AndroidVersion
import com.example.kotlin_coroutines_and_flow.mock.MockApi
import com.example.kotlin_coroutines_and_flow.mock.VersionFeatures
import com.example.kotlin_coroutines_and_flow.mock.mockAndroidVersions
import com.example.kotlin_coroutines_and_flow.utils.EndpointShouldNotBeCalledException

class FakeSuccessApi : MockApi {

    override suspend fun getRecentAndroidVersions(): List<AndroidVersion> {
        return mockAndroidVersions
    }

    override suspend fun getAndroidVersionFeatures(apiLevel: Int): VersionFeatures {
        throw EndpointShouldNotBeCalledException()
    }
}