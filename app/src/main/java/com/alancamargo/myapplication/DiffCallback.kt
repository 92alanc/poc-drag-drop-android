package com.alancamargo.myapplication

import androidx.recyclerview.widget.DiffUtil

class DiffCallback : DiffUtil.ItemCallback<MyEnum>() {

    override fun areContentsTheSame(oldItem: MyEnum, newItem: MyEnum): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: MyEnum, newItem: MyEnum): Boolean {
        return oldItem == newItem
    }

}