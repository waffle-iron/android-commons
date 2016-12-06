package com.elpassion.android.commons.recycler.components.group.impl

import com.elpassion.android.commons.recycler.components.group.MutableSectionedItemsStrategy

class CachedMapItemsStrategy<SectionType, ItemType>(private val itemsStrategy: MutableSectionedItemsStrategy<SectionType, ItemType>) : MutableSectionedItemsStrategy<SectionType, ItemType> by itemsStrategy {

    private var cache: List<ItemType>? = null

    override fun allItems() = cache ?: itemsStrategy.allItems().apply { cache = this }

    override fun addAll(section: SectionType, from: List<ItemType>) {
        itemsStrategy.addAll(section, from)
        cache = null
    }

    override fun add(section: SectionType, item: ItemType) {
        itemsStrategy.add(section, item)
        cache = null
    }

    override fun clear() {
        itemsStrategy.clear()
        cache = null
    }

    override fun set(section: SectionType, from: List<ItemType>) {
        itemsStrategy.set(section, from)
        cache = null
    }
}