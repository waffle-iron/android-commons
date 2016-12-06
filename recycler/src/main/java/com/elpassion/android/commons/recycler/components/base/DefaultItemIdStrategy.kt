package com.elpassion.android.commons.recycler.components.base

fun createDefaultItemIdStrategy(): (Int) -> Long = { position -> 0 }