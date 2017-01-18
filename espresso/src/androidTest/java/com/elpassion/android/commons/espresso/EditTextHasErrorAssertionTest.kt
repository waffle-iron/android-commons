package com.elpassion.android.commons.espresso

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.test.rule.ActivityTestRule
import android.widget.FrameLayout
import org.junit.Rule
import org.junit.Test

class EditTextHasErrorAssertionTest {

    @JvmField @Rule
    val activityRule = ActivityTestRule(Activity::class.java)

    @Test
    fun shouldConfirmEditTextHasError() {
        onId(anId).editTextHasError(textRes)
    }

    class Activity : android.app.Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(FrameLayout(this).apply {
                addView(TextInputLayout(this.context).apply {
                    addView(TextInputEditText(this.context).apply {
                        id = anId
                    })
                    error = context.getString(textRes)
                })
            })
        }
    }

    companion object {
        private val anId = 123
        private val textRes = R.string.app_name
    }
}