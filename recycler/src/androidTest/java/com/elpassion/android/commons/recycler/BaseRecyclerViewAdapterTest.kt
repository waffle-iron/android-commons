package com.elpassion.android.commons.recycler

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import org.junit.Test

class BaseRecyclerViewAdapterTest {

    @Test
    fun shouldCreateBaseRecyclerViewAdapterWithoutAdapters() {
        BaseRecyclerViewAdapter()
    }

    @Test
    fun shouldCreateBaseRecyclerViewAdapterWithAdaptersList() {
        BaseRecyclerViewAdapter(listOf(TestItemAdapter()))
    }


    private class TestItemAdapter : ItemAdapter<TestItemAdapter.TestViewHolder>(LAYOUT_ID) {
        override fun onCreateViewHolder(itemView: View) = TestViewHolder(itemView)

        override fun onBindViewHolder(holder: TestViewHolder) = Unit

        class TestViewHolder(itemView: View) : ViewHolder(itemView)

        companion object {
            private val LAYOUT_ID = 0
        }
    }
}