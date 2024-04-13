package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase6

import com.google.gson.Gson
import com.example.kotlin_coroutines_and_flow.mock.createMockApi
import com.example.kotlin_coroutines_and_flow.mock.mockAndroidVersions
import com.example.kotlin_coroutines_and_flow.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            { "something went wrong on server side" },
            500,
            1000,
            persist = false
        ).mock(
            "http://localhost/recent-android-versions",
            { "something went wrong on server side" },
            500,
            1000,
            persist = false
        ).mock(
            "http://localhost/recent-android-versions",
            { Gson().toJson(mockAndroidVersions) },
            200,
            1000
        )
)