package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase2

import com.google.gson.Gson
import com.example.kotlin_coroutines_and_flow.mock.createMockApi
import com.example.kotlin_coroutines_and_flow.mock.mockAndroidVersions
import com.example.kotlin_coroutines_and_flow.mock.mockVersionFeaturesAndroid10
import com.example.kotlin_coroutines_and_flow.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            { Gson().toJson(mockAndroidVersions) },
            200,
            1500
        )
        .mock(
            "http://localhost/android-version-features/29",
            { Gson().toJson(mockVersionFeaturesAndroid10) },
            200,
            1500
        )
)