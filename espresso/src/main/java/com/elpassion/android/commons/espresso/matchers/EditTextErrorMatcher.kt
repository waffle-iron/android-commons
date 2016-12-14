package com.elpassion.android.commons.espresso.matchers

import android.support.annotation.StringRes
import android.support.design.widget.TextInputLayout
import android.support.test.espresso.matcher.BoundedMatcher
import android.view.View
import android.widget.EditText
import org.hamcrest.Description

class EditTextErrorMatcher(@StringRes private val textId: Int) : BoundedMatcher<View, EditText>(EditText::class.java) {

    override fun matchesSafely(view: EditText): Boolean {
        val grandpa = view.parent?.parent
        if (grandpa is TextInputLayout) {
            return grandpa.error == view.context.getString(textId)
        }
        return false
    }

    override fun describeTo(description: Description) {
        description.appendText("has error text from string resource on TextInputLayout: $textId")
    }
}