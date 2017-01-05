package com.elpassion.android.commons.recycler.basic

import com.elpassion.android.commons.recycler.basic.impl.BasicListImpl
import com.elpassion.android.commons.recycler.basic.impl.BasicMapImpl

fun <K, V> Map<K, V>.asBasicMap(): BasicMap<K, V?> = BasicMapImpl(this)

fun <K, V> basicMapOf(vararg entries: Pair<K, V>): BasicMap<K, V?> {
    val map = mapOf<K, V>(*entries)
    return map.asBasicMap()
}

fun <Item> List<Item>.asBasicList(): BasicList<Item> = BasicListImpl(this)


