package com.elpassion.android.commons.recycler

import com.elpassion.android.commons.recycler.adapters.baseRecyclerViewAdapter
import com.elpassion.android.commons.recycler.adapters.mutableRecyclerViewAdapter
import org.junit.Test

class BaseRecyclerViewAdapterDelegateTest {

    @Test
    fun shouldCreateBaseRecyclerViewAdapterWithoutAdapters() {
        mutableRecyclerViewAdapter()
    }

    @Test
    fun shouldCreateBaseRecyclerViewAdapterWithAdaptersList() {
        baseRecyclerViewAdapter(mutableListOf(TestItemAdapter()))
    }
}