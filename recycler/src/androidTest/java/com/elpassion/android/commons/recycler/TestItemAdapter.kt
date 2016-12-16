package com.elpassion.android.commons.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import com.elpassion.android.commons.recycler.components.base.ItemAdapter

class TestItemAdapter : ItemAdapter<TestItemAdapter.TestViewHolder>(LAYOUT_ID) {
    override fun onCreateViewHolder(itemView: View) = TestViewHolder(itemView)

    override fun onBindViewHolder(holder: TestViewHolder) = Unit

    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        private val LAYOUT_ID = 0
    }
}