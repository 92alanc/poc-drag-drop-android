package com.alancamargo.myapplication

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object DependencyInjection {

    fun viewModel(activity: MainActivity) = lazy {
        val factory = getViewModelFactory(activity)
        ViewModelProvider(activity, factory).get(MyViewModel::class.java)
    }

    private fun getViewModelFactory(context: Context): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val preferenceManager = getPreferenceManager(context)
                return MyViewModel(preferenceManager) as T
            }
        }
    }

    private fun getPreferenceManager(context: Context) = PreferenceManager(context)

}
