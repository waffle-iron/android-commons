package com.elpassion.android.commons.recycler.basic

import com.elpassion.android.commons.recycler.basic.impl.BasicMapImpl

fun <K, V> Map<K, V>.asBasicMap(): BasicMap<K, V?> = BasicMapImpl(this)
