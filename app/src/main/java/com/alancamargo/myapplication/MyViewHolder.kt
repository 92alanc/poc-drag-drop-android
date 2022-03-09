package com.alancamargo.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.alancamargo.myapplication.databinding.ItemRecyclerViewBinding

class MyViewHolder(
    private val binding: ItemRecyclerViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindTo(item: MyEnum) = with(binding) {
        imageView.setImageResource(item.iconRes)
        textView.text = item.text
    }

}