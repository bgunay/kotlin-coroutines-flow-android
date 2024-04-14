package com.example.kotlin_coroutines_and_flow

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_coroutines_and_flow.base.BaseActivity
import com.example.kotlin_coroutines_and_flow.base.UseCaseActivity
import com.example.kotlin_coroutines_and_flow.base.UseCaseCategory
import com.example.kotlin_coroutines_and_flow.base.UseCaseCategoryAdapter
import com.example.kotlin_coroutines_and_flow.base.useCaseCategories
import com.example.kotlin_coroutines_and_flow.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideUpButton()
        initRecyclerView()
    }

    private val onUseCaseCategoryClickListener: (UseCaseCategory) -> Unit =
        { clickedUseCaseCategory ->
            val intent = UseCaseActivity.newIntent(applicationContext, clickedUseCaseCategory)
            startActivity(intent)
        }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            adapter =
                UseCaseCategoryAdapter(
                    useCaseCategories,
                    onUseCaseCategoryClickListener
                )
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(initItemDecoration())
        }
    }

    private fun initItemDecoration(): DividerItemDecoration {
        val itemDecorator =
            DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(
            ContextCompat.getDrawable(
                applicationContext,
                R.drawable.recyclerview_divider
            )!!
        )
        return itemDecorator
    }

    override fun getToolbarTitle() = "Coroutines and Flows on Android"
}
