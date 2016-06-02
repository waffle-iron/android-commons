package com.elpassion.android.commons.pager

import android.view.View

interface PagerItemAdapter {
    val layout: Int

    fun bind(view: View)
}