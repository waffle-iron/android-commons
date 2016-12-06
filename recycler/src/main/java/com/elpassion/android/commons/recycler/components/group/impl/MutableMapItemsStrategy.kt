package com.elpassion.android.commons.recycler.components.group.impl

import com.elpassion.android.commons.recycler.components.group.MutableSectionedItemsStrategy
import java.util.*

class MutableMapItemsStrategy<SectionType, ItemType> : MutableSectionedItemsStrategy<SectionType, ItemType> {

    private val items: MutableMap<SectionType, MutableList<ItemType>>

    constructor() {
        items = mutableMapOf()
    }

    constructor(list: Map<SectionType, List<ItemType>>) {
        items = LinkedHashMap<SectionType, MutableList<ItemType>>(list.size).apply {
            putAll(list.mapValues { it.value.toMutableList() })
        }
    }


    override fun addAll(section: SectionType, from: List<ItemType>) {
        items[section]!!.addAll(from)
    }

    override fun add(section: SectionType, item: ItemType) {
        items[section]!!.add(item)
    }

    override fun clear() {
        items.clear()
    }

    override fun set(section: SectionType, from: List<ItemType>) {
        items.put(section, from.toMutableList())
    }

    override fun allItems() = items.values.flatten()

    override fun getSection(section: SectionType) = items[section]!!.toList()

    override fun getRelativePosition(itemPosition: Int) = getRelativePosition(this, items, itemPosition)

    override fun getSectionForItemPosition(itemPosition: Int) = getSectionForItemAdapter(allItems()[itemPosition], items)

}