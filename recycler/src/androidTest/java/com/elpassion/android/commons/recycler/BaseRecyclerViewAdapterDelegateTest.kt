package com.elpassion.android.commons.recycler

import com.elpassion.android.commons.recycler.adapters.recyclerViewAdapter
import com.elpassion.android.commons.recycler.adapters.mutableRecyclerViewAdapter
import org.junit.Test

class BaseRecyclerViewAdapterDelegateTest {

    @Test
    fun shouldCreateBaseRecyclerViewAdapterWithoutAdapters() {
        mutableRecyclerViewAdapter()
    }

    @Test
    fun shouldCreateBaseRecyclerViewAdapterWithAdaptersList() {
        recyclerViewAdapter(mutableListOf(TestItemAdapter()))
    }
}