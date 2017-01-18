package com.elpassion.android.commons.espresso

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import org.junit.Rule
import org.junit.Test

class IsDisplayedTest {

    @JvmField @Rule
    val activityRule = ActivityTestRule(IsDisplayedTest.Activity::class.java)

    @Test
    fun shouldConfirmIsDisplayedWhenVisible() {
        onId(firstId).isDisplayed()
    }
    @Test
    fun shouldConfirmIsNotDisplayedWhenGone() {
        onId(secondId).isNotDisplayed()
    }
    @Test
    fun shouldConfirmIsNotDisplayedWhenInvisible() {
        onId(thirdId).isNotDisplayed()
    }

    class Activity : android.app.Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(FrameLayout(this).apply {
                addView(Button(this.context).apply {
                    id = firstId
                    visibility = View.VISIBLE
                })
                addView(Button(this.context).apply {
                    id = secondId
                    visibility = View.GONE
                })
                addView(Button(this.context).apply {
                    id = thirdId
                    visibility = View.INVISIBLE
                })
            })
        }
    }

    companion object {
        private val firstId = 123
        private val secondId = 124
        private val thirdId = 125
    }
}