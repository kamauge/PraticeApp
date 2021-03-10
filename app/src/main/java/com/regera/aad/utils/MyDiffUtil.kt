package com.regera.aad.utils

import androidx.recyclerview.widget.DiffUtil
import com.regera.aad.data.User

class MyDiffUtil(
    private val oldList: List<User>,
    private val newList: List<User>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }
            oldList[oldItemPosition].firstName != newList[newItemPosition].firstName -> {
                false
            }
            oldList[oldItemPosition].lastName != newList[newItemPosition].lastName -> {
                false
            }
            oldList[oldItemPosition].age != newList[newItemPosition].age -> {
                false
            }
            else -> true
        }
    }
}