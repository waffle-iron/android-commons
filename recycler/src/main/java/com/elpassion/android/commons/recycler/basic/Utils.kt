package com.elpassion.android.commons.recycler.basic

import com.elpassion.android.commons.recycler.basic.impl.BasicListImpl
import com.elpassion.android.commons.recycler.basic.impl.BasicMapImpl
import com.elpassion.android.commons.recycler.basic.impl.BasicMutableListImpl
import com.elpassion.android.commons.recycler.basic.impl.BasicMutableMapImpl

fun <K, V> Map<K, V>.asBasicMap(): BasicMap<K, V?> = BasicMapImpl(this)

fun <K, V> basicMapOf(vararg pairs: Pair<K, V>) = BasicMapImpl(mapOf(*pairs))

fun <K, V> MutableMap<K, V>.asBasicMutableMap(): BasicMutableMap<K, V?> = BasicMutableMapImpl(this)

fun <K, V> basicMutableMapOf(vararg pairs: Pair<K, V>) = BasicMutableMapImpl(mutableMapOf(*pairs))

fun <Item> List<Item>.asBasicList(): BasicList<Item> = BasicListImpl(this)

fun <Item> MutableList<Item>.asBasicMutableList(): BasicMutableList<Item> = BasicMutableListImpl(this)

fun <Item> basicListOf(vararg items: Item) = BasicListImpl(listOf(*items))

fun <K, V> Map<K, List<V>>.asBasicMapOfBasicLists(): BasicMap<K, BasicList<V>?> = object : BasicMap<K, BasicList<V>?> {
    override fun get(key: K) = this@asBasicMapOfBasicLists[key]?.asBasicList()
}

