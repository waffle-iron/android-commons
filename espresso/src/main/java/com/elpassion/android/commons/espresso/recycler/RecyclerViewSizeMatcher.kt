package com.elpassion.android.commons.espresso.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

fun recyclerViewSizeMatcher(expectedSize: Int): Matcher<View> = object : TypeSafeMatcher<View>() {
    public override fun matchesSafely(view: View): Boolean {
        val groupSize = getGroupCount(view)
        return groupSize == expectedSize
    }

    private fun getGroupCount(view: View): Int {
        val groupSize = when (view) {
            is RecyclerView -> view.adapter.itemCount
            is ListView -> view.adapter.count
            is ViewGroup -> view.childCount
            else -> throw IllegalArgumentException("Unknown view type")
        }
        return groupSize
    }

    override fun describeTo(description: Description) {
        description.appendText("List should have $expectedSize items")
    }
}

