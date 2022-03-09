package com.alancamargo.myapplication

import android.content.Context

private const val KEY = "my_key"

class PreferenceManager(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        "prefs",
        Context.MODE_PRIVATE
    )

    fun setPositions(positions: List<Int>) {
        val value = positions.joinToString(",")
        sharedPreferences.edit().putString(KEY, value).apply()
    }

    fun getPositions(): List<Int>? {
        val str = sharedPreferences.getString(KEY, null)

        return str?.split(",")?.map { it.toInt() }
    }

}
