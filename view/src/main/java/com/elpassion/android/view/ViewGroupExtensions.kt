package com.elpassion.android.view

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View {
    val inflater = LayoutInflater.from(context)
    return inflater.inflate(layoutId, this, attachToRoot)
}
