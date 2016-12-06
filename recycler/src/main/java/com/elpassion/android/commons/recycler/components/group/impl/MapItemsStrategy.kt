package com.elpassion.android.commons.recycler.components.group.impl

import com.elpassion.android.commons.recycler.components.group.SectionedItemsStrategy
import java.util.*

class MapItemsStrategy<SectionType, ItemType>(list: Map<SectionType, List<ItemType>>) : SectionedItemsStrategy<SectionType, ItemType> {

    private val items: Map<SectionType, List<ItemType>> = LinkedHashMap<SectionType, List<ItemType>>(list.size).apply {
        putAll(list.mapValues { ArrayList(it.value) })
    }

    override fun allItems() = items.values.flatten()

    override fun getSection(section: SectionType) = items[section]!!.toList()

    override fun getRelativePosition(itemPosition: Int) = getRelativePosition(this, items, itemPosition)

    override fun getSectionForItemPosition(itemPosition: Int) = getSectionForItemAdapter(allItems()[itemPosition], items)
}

