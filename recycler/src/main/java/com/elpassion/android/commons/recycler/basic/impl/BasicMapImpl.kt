package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicMap

class BasicMapImpl<Key, Value>(val source: Map<Any, Any>) : BasicMap<Key, Value> {
    override fun get(key: Key): Value {
        throw NotImplementedError()
    }
}