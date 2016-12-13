package com.elpassion.android.commons.recycler.components.stable

import android.support.v7.widget.RecyclerView
import com.elpassion.android.commons.recycler.RecyclerViewAdapterCompositor

fun <T : StableItemAdapter<out RecyclerView.ViewHolder>> createStableIdInitialization() =
        { compositor: RecyclerViewAdapterCompositor<T> ->
            compositor.setHasStableIds(true)
        }