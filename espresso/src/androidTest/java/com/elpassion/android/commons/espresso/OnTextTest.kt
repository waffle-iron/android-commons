package com.elpassion.android.commons.espresso

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.widget.Button
import android.widget.FrameLayout
import org.junit.Rule
import org.junit.Test

class OnTextTest {

    @JvmField @Rule
    val activityRule = ActivityTestRule(Activity::class.java)

    @Test
    fun shouldNotFindViewWithText() {
        onText(notExistingText).doesNotExist()
    }

    @Test
    fun shouldFindViewWithText() {
        onText(existingText).isDisplayed()
    }

    class Activity : android.app.Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(FrameLayout(this).apply {
                addView(Button(this.context).apply {
                    text = existingText
                })
            })
        }
    }

    companion object {
        private val notExistingText = "not existing"
        private val existingText = "existing"
    }
}