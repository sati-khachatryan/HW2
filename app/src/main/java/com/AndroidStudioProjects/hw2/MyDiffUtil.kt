package com.AndroidStudioProjects.hw2

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil (
    private val oldList: List<Contact>,
    private val newList: List<Contact>
    ): DiffUtil.Callback (){

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList == newList
    }
}