package com.elpassion.android.view

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun inflate(parent: ViewGroup, @LayoutRes layoutId: Int): View {
    val inflater = LayoutInflater.from(parent.context)
    return inflater.inflate(layoutId, parent, false)
}
