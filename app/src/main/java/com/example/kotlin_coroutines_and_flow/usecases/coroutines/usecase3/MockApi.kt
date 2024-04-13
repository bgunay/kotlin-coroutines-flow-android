package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase3

import com.google.gson.Gson
import com.example.kotlin_coroutines_and_flow.mock.createMockApi
import com.example.kotlin_coroutines_and_flow.mock.mockVersionFeaturesAndroid10
import com.example.kotlin_coroutines_and_flow.mock.mockVersionFeaturesOreo
import com.example.kotlin_coroutines_and_flow.mock.mockVersionFeaturesPie
import com.example.kotlin_coroutines_and_flow.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/android-version-features/27",
            { Gson().toJson(mockVersionFeaturesOreo) },
            200,
            1000
        )
        .mock(
            "http://localhost/android-version-features/28",
            { Gson().toJson(mockVersionFeaturesPie) },
            200,
            1000
        )
        .mock(
            "http://localhost/android-version-features/29",
            { Gson().toJson(mockVersionFeaturesAndroid10) },
            200,
            1000
        )
)