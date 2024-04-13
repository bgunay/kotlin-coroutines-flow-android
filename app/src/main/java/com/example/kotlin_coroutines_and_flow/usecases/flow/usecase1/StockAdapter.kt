package com.example.kotlin_coroutines_and_flow.usecases.flow.usecase1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_coroutines_and_flow.R
import com.example.kotlin_coroutines_and_flow.databinding.RecyclerviewItemStockBinding
import com.example.kotlin_coroutines_and_flow.usecases.flow.mock.Stock
import java.text.NumberFormat

class StockAdapter: RecyclerView.Adapter<StockAdapter.StockViewHolder>() {

    var stockList: List<Stock>? = null
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    private val formatter: NumberFormat = NumberFormat.getCurrencyInstance()

    class StockViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RecyclerviewItemStockBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_stock, parent, false)
        return StockViewHolder(view)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) = with(holder.binding){
        val stock = stockList?.get(position) ?: return@with
        rank.text = stock.rank.toString()
        name.text = stock.name
        val currentPriceFormatted: String = formatter.format(stock.currentPrice)
        currentPrice.text = currentPriceFormatted
    }

    override fun getItemCount(): Int {
        return stockList?.size ?: 0
    }

}