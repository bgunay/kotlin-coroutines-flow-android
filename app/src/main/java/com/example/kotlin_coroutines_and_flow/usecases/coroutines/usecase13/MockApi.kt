package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase13

import com.google.gson.Gson
import com.example.kotlin_coroutines_and_flow.mock.*
import com.example.kotlin_coroutines_and_flow.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            { Gson().toJson(mockAndroidVersions) },
            200,
            1000
        )
        .mock(
            "http://localhost/android-version-features/27",
            { Gson().toJson(mockVersionFeaturesOreo) },
            MockNetworkInterceptor.INTERNAL_SERVER_ERROR_HTTP_CODE,
            100
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