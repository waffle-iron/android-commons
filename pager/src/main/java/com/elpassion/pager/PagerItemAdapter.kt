package com.elpassion.pager

import android.view.View

interface PagerItemAdapter {
    val layout: Int

    fun bind(view: View)
}