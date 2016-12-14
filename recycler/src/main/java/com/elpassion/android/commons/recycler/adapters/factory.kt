package com.elpassion.android.commons.recycler.adapters

import android.support.v7.widget.RecyclerView
import com.elpassion.android.commons.recycler.RecyclerViewCompositeAdapter
import com.elpassion.android.commons.recycler.components.ItemsStrategy
import com.elpassion.android.commons.recycler.components.base.ItemAdapter
import com.elpassion.android.commons.recycler.components.base.ListItemsStrategy
import com.elpassion.android.commons.recycler.components.base.MutableListItemsStrategy
import com.elpassion.android.commons.recycler.components.group.SectionedItemsStrategy
import com.elpassion.android.commons.recycler.components.stable.StableItemAdapter
import com.elpassion.android.commons.recycler.components.stable.createStableIdInitialization
import com.elpassion.android.commons.recycler.components.stable.getStableItemIdentifier

fun recyclerViewAdapter(adapters: List<ItemAdapter<*>>) = RecyclerViewCompositeAdapter(ListItemsStrategy(adapters))

fun mutableRecyclerViewAdapter(adapters: MutableList<ItemAdapter<*>> = mutableListOf()) = RecyclerViewCompositeAdapter(MutableListItemsStrategy(adapters))

fun stableRecyclerViewAdapter(itemsStrategy: ItemsStrategy<StableItemAdapter<out RecyclerView.ViewHolder>>) =
        RecyclerViewCompositeAdapter(
                itemsStrategy = itemsStrategy,
                getItemIdentifier = getStableItemIdentifier(itemsStrategy),
                init = createStableIdInitialization())

fun <Section, Item : StableItemAdapter<out RecyclerView.ViewHolder>> stableSectionedRecyclerViewAdapter(itemsStrategy: SectionedItemsStrategy<Section, Item>) =
        RecyclerViewCompositeAdapter(
                itemsStrategy = itemsStrategy,
                getItemIdentifier = getStableItemIdentifier(itemsStrategy),
                init = createStableIdInitialization())