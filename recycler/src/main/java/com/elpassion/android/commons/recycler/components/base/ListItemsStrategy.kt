package com.elpassion.android.commons.recycler.components.base

import com.elpassion.android.commons.recycler.components.ItemsStrategy
import java.util.*

class ListItemsStrategy<T>(list: List<T>) : ItemsStrategy<T> {

    private val items: List<T> = ArrayList<T>(list)

    override fun allItems() = items
}

