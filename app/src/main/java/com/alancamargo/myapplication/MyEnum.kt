package com.alancamargo.myapplication

import androidx.annotation.DrawableRes

enum class MyEnum(
    val startingPosition: Int,
    @DrawableRes val iconRes: Int,
    val text: String
) {

    FIRST_ITEM(
        startingPosition = 0,
        iconRes = R.drawable.ic_baseline_construction_24,
        text = "First item"
    ),
    SECOND_ITEM(
        startingPosition = 1,
        iconRes = R.drawable.ic_baseline_coronavirus_24,
        text = "Second item"
    ),
    THIRD_ITEM(
        startingPosition = 2,
        iconRes = R.drawable.ic_baseline_cruelty_free_24,
        text = "Third item"
    ),
    FOURTH_ITEM(
        startingPosition = 3,
        iconRes = R.drawable.ic_baseline_currency_pound_24,
        text = "Fourth item"
    ),
    FIFTH_ITEM(
        startingPosition = 4,
        iconRes = R.drawable.ic_baseline_cyclone_24,
        text = "Fifth item"
    );

    companion object {
        private val items = values()

        fun fromPosition(position: Int): MyEnum {
            return items.first { it.startingPosition == position }
        }
    }

}
