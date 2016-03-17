package com.elpassion.android.view

import android.app.Application
import android.test.ApplicationTestCase
import android.view.View

class ViewTest : ApplicationTestCase<Application>(Application::class.java) {

    fun testShouldSetViewVisibilityToVisible() {
        val view = View(context)
        view.visibility = View.INVISIBLE
        view.show()
        assertEquals(View.VISIBLE, view.visibility)
    }
}