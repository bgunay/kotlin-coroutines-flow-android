package com.example.kotlin_coroutines_and_flow.usecases.flow.usecase4

import android.content.Context
import com.google.gson.Gson
import com.example.kotlin_coroutines_and_flow.usecases.flow.mock.createFlowMockApi
import com.example.kotlin_coroutines_and_flow.usecases.flow.mock.fakeCurrentStockPrices
import com.example.kotlin_coroutines_and_flow.utils.MockNetworkInterceptor

fun mockApi(context: Context) =
    createFlowMockApi(
        MockNetworkInterceptor()
            .mock(
                path = "/current-stock-prices",
                body = { Gson().toJson(fakeCurrentStockPrices(context)) },
                status = 200,
                delayInMs = 1500,
            )
    )