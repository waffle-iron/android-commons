package com.elpassion.android.view

import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.isVisible(): Boolean = visibility == View.VISIBLE

fun View.disable() {
    isEnabled = false
}

fun View.enable(){
    isEnabled = true
}