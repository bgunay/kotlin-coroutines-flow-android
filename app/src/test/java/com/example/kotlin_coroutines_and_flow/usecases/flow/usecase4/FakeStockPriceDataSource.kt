package com.example.kotlin_coroutines_and_flow.usecases.flow.usecase4

import com.example.kotlin_coroutines_and_flow.usecases.flow.mock.Stock
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class FakeStockPriceDataSource : StockPriceDataSource {

    private val sharedFlow = MutableSharedFlow<List<Stock>>()

    suspend fun emit(stockList: List<Stock>) {
        sharedFlow.emit(stockList)
    }

    override val latestStockList: Flow<List<Stock>> = sharedFlow.asSharedFlow()

}
