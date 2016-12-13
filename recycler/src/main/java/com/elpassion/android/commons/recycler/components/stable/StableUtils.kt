package com.elpassion.android.commons.recycler.components.stable

import android.support.v7.widget.RecyclerView
import com.elpassion.android.commons.recycler.RecyclerViewAdapterCompositor
import com.elpassion.android.commons.recycler.components.ItemsStrategy

fun <T : StableItemAdapter<out RecyclerView.ViewHolder>> getStableItemIdentifier(itemsStrategy: ItemsStrategy<T>) =
        { position: Int ->
            itemsStrategy.allItems()[position].stableId
        }

fun <T : StableItemAdapter<out RecyclerView.ViewHolder>> createStableIdInitialization() =
        { compositor: RecyclerViewAdapterCompositor<T> ->
            compositor.setHasStableIds(true)
        }