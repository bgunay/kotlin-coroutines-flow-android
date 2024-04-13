package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase2.callbacks

import com.example.kotlin_coroutines_and_flow.mock.AndroidVersion
import com.example.kotlin_coroutines_and_flow.mock.VersionFeatures
import com.example.kotlin_coroutines_and_flow.mock.mockAndroidVersions
import retrofit2.Call
import retrofit2.mock.Calls
import java.io.IOException

class FakeVersionsErrorApi : CallbackMockApi {

    override fun getRecentAndroidVersions(): Call<List<AndroidVersion>> {
        return Calls.response(mockAndroidVersions)
    }

    override fun getAndroidVersionFeatures(apiLevel: Int): Call<VersionFeatures> {
        return Calls.failure(IOException())
    }
}