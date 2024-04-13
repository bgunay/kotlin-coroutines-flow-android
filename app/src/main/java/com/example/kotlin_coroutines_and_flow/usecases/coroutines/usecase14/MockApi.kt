package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase14

import com.google.gson.Gson
import com.example.kotlin_coroutines_and_flow.mock.createMockApi
import com.example.kotlin_coroutines_and_flow.mock.mockAndroidVersions
import com.example.kotlin_coroutines_and_flow.utils.MockNetworkInterceptor

fun mockApi() =
    createMockApi(
        MockNetworkInterceptor()
            .mock(
                "http://localhost/recent-android-versions",
                { Gson().toJson(mockAndroidVersions) },
                200,
                5000
            )
    )