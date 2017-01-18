package com.elpassion.android.commons.espresso

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.widget.Button
import android.widget.FrameLayout
import org.junit.Rule
import org.junit.Test

class HasChildWithTextAssertionsTest {

    @JvmField @Rule
    val activityRule = ActivityTestRule(Activity::class.java)

    @Test
    fun shouldConfirmHasChildWithText() {
        onId(anId).hasChildWithText(firstText)
    }

    @Test
    fun shouldConfirmHasChildWithTextRes() {
        onId(anId).hasChildWithText(secondTextRes)
    }

    @Test
    fun shouldConfirmDoesNotHaveChildWithText() {
        onId(anId).doesNotHaveChildWithText("not existing text")
    }

    @Test
    fun shouldConfirmDoesNotHaveChildWithTextRes() {
        onId(anId).doesNotHaveChildWithText(123)
    }

    class Activity : android.app.Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(FrameLayout(this).apply {
                id = anId
                addView(Button(this.context).apply {
                    text = firstText
                })
                addView(Button(this.context).apply {
                    setText(secondTextRes)
                })
            })
        }
    }

    companion object {
        private val anId = 124
        private val firstText = "text"
        private val secondTextRes = R.string.app_name
    }
}