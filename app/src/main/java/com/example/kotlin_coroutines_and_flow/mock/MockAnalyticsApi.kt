package com.example.kotlin_coroutines_and_flow.mock

import com.example.kotlin_coroutines_and_flow.utils.MockNetworkInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MockAnalyticsApi {

    @GET("analytics/workmanager-screen-opened")
    suspend fun trackScreenOpened(): Boolean
}

fun createMockAnalyticsApi(interceptor: MockNetworkInterceptor): MockAnalyticsApi {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(MockAnalyticsApi::class.java)
}