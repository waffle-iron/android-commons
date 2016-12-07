package com.elpassion.android.commons.espresso.matchers

import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.test.espresso.matcher.BoundedMatcher
import android.view.View
import org.hamcrest.Description

class TextInputEditTextHintMatcher(private val hintStringId: Int) : BoundedMatcher<View, TextInputEditText>(TextInputEditText::class.java) {

    override fun matchesSafely(view: TextInputEditText): Boolean {
        val grandpa = view.parent?.parent
        if (grandpa is TextInputLayout) {
            return grandpa.hint == view.context.getString(hintStringId)
        }
        return false
    }

    override fun describeTo(description: Description) {
        description.appendText("has hint text from string resource on TextInputLayout: " + hintStringId)
    }
}