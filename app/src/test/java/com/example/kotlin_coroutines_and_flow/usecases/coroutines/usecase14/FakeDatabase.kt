package com.example.kotlin_coroutines_and_flow.usecases.coroutines.usecase14

import com.example.kotlin_coroutines_and_flow.mock.mockAndroidVersions

class FakeDatabase : AndroidVersionDao {

    var insertedIntoDb = false

    override suspend fun getAndroidVersions(): List<AndroidVersionEntity> {
        return mockAndroidVersions.mapToEntityList()
    }

    override suspend fun insert(androidVersionEntity: AndroidVersionEntity) {
        insertedIntoDb = true
    }

    override suspend fun clear() {}

}