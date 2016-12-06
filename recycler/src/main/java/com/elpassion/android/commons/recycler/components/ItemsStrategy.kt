package com.elpassion.android.commons.recycler.components

interface ItemsStrategy<T> {
    fun allItems(): List<T>
}

