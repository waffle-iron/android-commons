package com.elpassion.android.commons.espresso

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.widget.Button
import android.widget.FrameLayout
import org.junit.Rule
import org.junit.Test

class HasTextAssertionsTest {

    @JvmField @Rule
    val activityRule = ActivityTestRule(Activity::class.java)

    @Test
    fun shouldConfirmHasText() {
        onId(firstId).hasText(firstText)
    }

    @Test
    fun shouldConfirmHasTextFromRes() {
        onId(secondId).hasText(secondTextRes)
    }

    class Activity : android.app.Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(FrameLayout(this).apply {
                addView(Button(this.context).apply {
                    id = firstId
                    text = firstText
                })
                addView(Button(this.context).apply {
                    id = secondId
                    setText(secondTextRes)
                })
            })
        }
    }

    companion object {
        private val firstId = 123
        private val firstText = "text"
        private val secondId = 124
        private val secondTextRes = R.string.app_name
    }
}