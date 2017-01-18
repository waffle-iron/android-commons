package com.elpassion.android.commons.espresso

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.widget.FrameLayout
import android.widget.RadioButton
import org.junit.Rule
import org.junit.Test

class CheckedAssertionsTest {

    @JvmField @Rule
    val activityRule = ActivityTestRule(Activity::class.java)

    @Test
    fun shouldConfirmIsChecked() {
        onId(firstId).isChecked()
    }

    @Test
    fun shouldConfirmIsNotChecked() {
        onId(secondId).isNotChecked()
    }

    class Activity : android.app.Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(FrameLayout(this).apply {
                addView(RadioButton(this.context).apply {
                    id = firstId
                    isChecked = true
                })
                addView(RadioButton(this.context).apply {
                    id = secondId
                    isChecked = false
                })
            })
        }
    }

    companion object {
        private val firstId = 123
        private val secondId = 124
    }
}