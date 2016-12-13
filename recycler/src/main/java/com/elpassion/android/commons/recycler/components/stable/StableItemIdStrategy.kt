package com.elpassion.android.commons.recycler.components.stable

import android.support.v7.widget.RecyclerView
import com.elpassion.android.commons.recycler.components.ItemsStrategy

fun <T : StableItemAdapter<out RecyclerView.ViewHolder>> getStableItemIdent(itemsStrategy: ItemsStrategy<T>): (Int) -> Long =
        { position ->
            itemsStrategy.allItems()[position].stableId
        }