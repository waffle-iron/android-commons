package com.elpassion.android.commons.espresso

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.widget.Button
import android.widget.FrameLayout
import org.junit.Rule
import org.junit.Test

class HasChildCountAssertionTest {

    @JvmField @Rule
    val activityRule = ActivityTestRule(Activity::class.java)

    @Test
    fun shouldConfirmParentHasCorrectChildCount() {
        onId(rootId).hasChildCount(1)
        onId(childId).hasChildCount(3)
    }

    class Activity : android.app.Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(FrameLayout(this).apply {
                id = rootId
                addView(FrameLayout(context).apply {
                    id = childId
                    addView(Button(context))
                    addView(Button(context))
                    addView(Button(context))
                })
            })
        }
    }

    companion object {
        private val rootId = 123
        private val childId = 124
    }
}