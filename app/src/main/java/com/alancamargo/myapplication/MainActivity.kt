package com.alancamargo.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alancamargo.myapplication.databinding.ActivityMainBinding
import java.util.Collections

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val adapter = MyAdapter()
    private val viewModel by DependencyInjection.viewModel(activity = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter

        viewModel.getItems().observe(this) {
            val dragAndDropGesture = dragAndDropGesture { fromPosition, toPosition ->
                Collections.swap(it, fromPosition, toPosition)
                viewModel.setItems(it)
                adapter.notifyItemMoved(fromPosition, toPosition)
            }

            dragAndDropGesture.attachToRecyclerView(binding.recyclerView)

            adapter.submitList(it)
        }

        viewModel.fetchItems()
    }

}
