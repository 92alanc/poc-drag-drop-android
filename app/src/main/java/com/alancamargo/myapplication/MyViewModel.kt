package com.alancamargo.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel(private val preferenceManager: PreferenceManager) : ViewModel() {

    private val itemsLiveData = MutableLiveData<List<MyEnum>>()

    fun getItems(): LiveData<List<MyEnum>> = itemsLiveData

    fun fetchItems() {
        val items = preferenceManager.getPositions()?.map {
            MyEnum.fromPosition(it)
        } ?: MyEnum.values().sortedBy { it.startingPosition }

        itemsLiveData.value = items
    }

    fun setItems(items: List<MyEnum>) {
        val positions = items.map { it.startingPosition }
        preferenceManager.setPositions(positions)
    }

}
