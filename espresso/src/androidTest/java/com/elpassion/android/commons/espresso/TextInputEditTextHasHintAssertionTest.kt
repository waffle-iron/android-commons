package com.elpassion.android.commons.espresso

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.test.rule.ActivityTestRule
import android.widget.FrameLayout
import org.junit.Rule
import org.junit.Test

class TextInputEditTextHasHintAssertionTest {

    @JvmField @Rule
    val activityRule = ActivityTestRule(Activity::class.java)

    @Test
    fun shouldConfirmTextInputEditTextHasHint() {
        onId(anId).textInputEditTextHasHint(textId)
    }

    class Activity : android.app.Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(FrameLayout(this).apply {
                addView(TextInputLayout(this.context).apply {
                    addView(TextInputEditText(this.context).apply {
                        id = anId
                        hint = context.getString(textId)
                    })
                })
            })
        }
    }

    companion object {
        private val anId = 123
        private val textId = R.string.app_name
    }
}