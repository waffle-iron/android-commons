package com.elpassion.android.commons.recycler.adapters

import android.support.v7.widget.RecyclerView
import com.elpassion.android.commons.recycler.RecyclerViewAdapterCompositor
import com.elpassion.android.commons.recycler.components.ItemsStrategy
import com.elpassion.android.commons.recycler.components.base.ItemAdapter
import com.elpassion.android.commons.recycler.components.base.ListItemsStrategy
import com.elpassion.android.commons.recycler.components.base.MutableListItemsStrategy
import com.elpassion.android.commons.recycler.components.group.SectionedItemsStrategy
import com.elpassion.android.commons.recycler.components.stable.StableItemAdapter
import com.elpassion.android.commons.recycler.components.stable.createStableIdInitializationStrategy
import com.elpassion.android.commons.recycler.components.stable.createStableItemIdStrategy

fun baseRecyclerViewAdapter(adapters: List<ItemAdapter<*>>) = RecyclerViewAdapterCompositor(ListItemsStrategy(adapters))

fun mutableRecyclerViewAdapter(adapters: MutableList<ItemAdapter<*>> = mutableListOf()) = RecyclerViewAdapterCompositor(MutableListItemsStrategy(adapters))

fun stableRecyclerViewAdapter(itemsStrategy: ItemsStrategy<StableItemAdapter<out RecyclerView.ViewHolder>>) =
        RecyclerViewAdapterCompositor(
                itemsStrategy = itemsStrategy,
                itemIdStrategy = createStableItemIdStrategy(itemsStrategy),
                initializationStrategy = createStableIdInitializationStrategy())

fun <Section, Item : StableItemAdapter<out RecyclerView.ViewHolder>> stableSectionedRecyclerViewAdapter(itemsStrategy: SectionedItemsStrategy<Section, Item>) =
        RecyclerViewAdapterCompositor(
                itemsStrategy = itemsStrategy,
                itemIdStrategy = createStableItemIdStrategy(itemsStrategy),
                initializationStrategy = createStableIdInitializationStrategy())