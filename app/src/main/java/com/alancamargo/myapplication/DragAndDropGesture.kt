package com.alancamargo.myapplication

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

fun dragAndDropGesture(
    onGestureCompleted: (fromPosition: Int, toPosition: Int) -> Unit
): ItemTouchHelper {
    val gesture = object : DragAndDropGesture() {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val fromPosition = viewHolder.adapterPosition
            val toPosition = target.adapterPosition
            onGestureCompleted(fromPosition, toPosition)
            return false
        }
    }

    return ItemTouchHelper(gesture)
}

abstract class DragAndDropGesture : ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.START or ItemTouchHelper.END,
    ItemTouchHelper.ACTION_STATE_IDLE
) {

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        // Do nothing
    }

}
