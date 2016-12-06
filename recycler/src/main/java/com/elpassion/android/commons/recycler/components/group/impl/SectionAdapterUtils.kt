package com.elpassion.android.commons.recycler.components.group.impl

import com.elpassion.android.commons.recycler.components.group.SectionedItemsStrategy

internal fun <ItemType, SectionType> getSectionForItemAdapter(itemAdapter: ItemType, adapters: Map<SectionType, List<ItemType>>): SectionType
        = adapters.filterValues { it.contains(itemAdapter) }.keys.first()

internal fun <ItemType, SectionType> getRelativePosition(strategy: SectionedItemsStrategy<SectionType, ItemType>,
                                                         adapters: Map<SectionType, List<ItemType>>,
                                                         itemPosition: Int): Int {
    val itemAdapter = strategy.allItems()[itemPosition]
    val section = getSectionForItemAdapter(itemAdapter, adapters)
    return strategy.getSection(section).indexOf(itemAdapter)
}