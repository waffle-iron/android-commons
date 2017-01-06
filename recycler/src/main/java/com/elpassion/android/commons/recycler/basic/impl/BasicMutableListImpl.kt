package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicMutableList

class BasicMutableListImpl<Item>(private val source: MutableList<Item>) : BasicMutableList<Item> {

    override val size: Int get() = source.size

    override fun get(key: Int) = source[key]

    override fun set(key: Int, value: Item): Unit = TODO()

    override fun clear() = TODO()

    override fun insert(index: Int, item: Item) = TODO()

    override fun remove(index: Int): Unit = TODO()
}