package com.elpassion.android.commons.recycler.basic

import com.elpassion.android.commons.recycler.basic.impl.BasicListImpl
import com.elpassion.android.commons.recycler.basic.impl.BasicMapImpl

fun <K, V> Map<K, V>.asBasicMap(): BasicMap<K, V?> = BasicMapImpl(this)

fun <K, V> basicMapOf(vararg pairs: Pair<K, V>) = BasicMapImpl(mapOf(*pairs))

fun <Item> List<Item>.asBasicList(): BasicList<Item> = BasicListImpl(this)

fun <Item> basicListOf(vararg items: Item) = BasicListImpl(listOf(*items))

fun <K, V> Map<K, List<V>>.asBasicMapOfBasicLists(): BasicMap<K, BasicList<V>?> = object : BasicMap<K, BasicList<V>?> {
    override fun get(key: K) = this@asBasicMapOfBasicLists[key]?.asBasicList()
}

