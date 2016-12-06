package com.elpassion.android.commons.recycler.components.group

import com.elpassion.android.commons.recycler.components.ItemsStrategy


interface SectionedItemsStrategy<SectionType, ItemType> : ItemsStrategy<ItemType> {
    fun getSection(section: SectionType): List<ItemType>

    fun getRelativePosition(itemPosition: Int): Int

    fun getSectionForItemPosition(itemPosition: Int): SectionType
}

interface MutableSectionedItemsStrategy<SectionType, ItemType> : SectionedItemsStrategy<SectionType, ItemType> {
    fun addAll(section: SectionType, from: List<ItemType>)

    fun add(section: SectionType, item: ItemType)

    fun clear()

    fun set(section: SectionType, from: List<ItemType>)
}