package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicList
import com.elpassion.android.commons.recycler.basic.BasicListWithSections
import com.elpassion.android.commons.recycler.basic.basicMapOf

class BasicListWithSectionsImpl<Item, Section>(private val source: Map<Section, List<Item>>) : BasicListWithSections<Item, Section> {

    override val sections = basicMapOf<Section, BasicList<Item>>() // TODO

    override fun get(key: Int) = TODO()

    override val size: Int get() = 0
}