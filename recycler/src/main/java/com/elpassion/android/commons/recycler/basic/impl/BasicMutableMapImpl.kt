package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicMutableMap

class BasicMutableMapImpl<Key, Value>(private val source: MutableMap<Key, Value>) : BasicMutableMap<Key, Value?> {

    override fun get(key: Key): Value? = source[key]

    override fun set(key: Key, value: Value?) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}