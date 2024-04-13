package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase1

import com.example.kotlin_coroutines_and_flow.mock.AndroidVersion
import com.example.kotlin_coroutines_and_flow.mock.MockApi
import com.example.kotlin_coroutines_and_flow.mock.VersionFeatures
import com.example.kotlin_coroutines_and_flow.utils.EndpointShouldNotBeCalledException
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response

class FakeErrorApi() : MockApi {

    override suspend fun getRecentAndroidVersions(): List<AndroidVersion> {
        throw HttpException(
            Response.error<List<AndroidVersion>>(
                500,
                ResponseBody.create(MediaType.parse("application/json"), "")
            )
        )
    }

    override suspend fun getAndroidVersionFeatures(apiLevel: Int): VersionFeatures {
        throw EndpointShouldNotBeCalledException()
    }
}