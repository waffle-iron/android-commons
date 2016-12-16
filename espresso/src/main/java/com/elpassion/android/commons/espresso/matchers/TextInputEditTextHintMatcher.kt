package com.elpassion.android.commons.espresso.matchers

import android.support.annotation.StringRes
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.support.test.espresso.matcher.BoundedMatcher
import android.view.View
import org.hamcrest.Description

class TextInputEditTextHintMatcher(@StringRes private val textId: Int) : BoundedMatcher<View, TextInputEditText>(TextInputEditText::class.java) {

    override fun matchesSafely(view: TextInputEditText): Boolean {
        val grandpa = view.parent?.parent
        if (grandpa is TextInputLayout) {
            return grandpa.hint == view.context.getString(textId)
        }
        return false
    }

    override fun describeTo(description: Description) {
        description.appendText("has hint text from string resource on TextInputLayout: $textId")
    }
}