package com.elpassion.android.commons.recycler.basic

import com.elpassion.android.commons.recycler.basic.impl.BasicListImpl
import com.elpassion.android.commons.recycler.basic.impl.BasicMapImpl

fun <K, V> Map<K, V>.asBasicMap(): BasicMap<K, V?> = BasicMapImpl(this)

fun <K, V> basicMapOf(vararg entries: Pair<K, V>) = BasicMapImpl(mapOf<K, V>(*entries))

fun <Item> List<Item>.asBasicList(): BasicList<Item> = BasicListImpl(this)

fun <Item> basicListOf(vararg items: Item) = BasicListImpl(listOf<Item>(*items))

