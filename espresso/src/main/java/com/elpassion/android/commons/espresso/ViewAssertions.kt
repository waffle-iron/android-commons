package com.elpassion.android.commons.espresso

import android.support.annotation.StringRes
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.espresso.matcher.ViewMatchers.Visibility.GONE
import com.elpassion.android.commons.espresso.matchers.EditTextErrorMatcher
import com.elpassion.android.commons.espresso.matchers.TextInputEditTextHintMatcher
import com.elpassion.android.commons.espresso.recycler.recyclerViewSizeMatcher
import org.hamcrest.core.IsNot.not

fun ViewInteraction.isDisplayed() = check(matches(ViewMatchers.isDisplayed()))

fun ViewInteraction.isNotDisplayed() = check(matches(not(ViewMatchers.isDisplayed())))

fun ViewInteraction.isGone() = check(matches(withEffectiveVisibility(GONE)))

fun ViewInteraction.doesNotExist() = check(ViewAssertions.doesNotExist())

fun ViewInteraction.hasText(@StringRes textId: Int) = check(matches(withText(textId)))

fun ViewInteraction.hasText(text: String) = check(matches(withText(text)))

fun ViewInteraction.isEnabled() = check(matches(ViewMatchers.isEnabled()))

fun ViewInteraction.isDisabled() = check(matches(not(ViewMatchers.isEnabled())))

fun ViewInteraction.isChecked() = check(matches(ViewMatchers.isChecked()))

fun ViewInteraction.isNotChecked() = check(matches(not(ViewMatchers.isChecked())))

fun ViewInteraction.hasChildWithText(@StringRes textId: Int) = check(matches(hasDescendant(withText(textId))))

fun ViewInteraction.hasChildWithText(text: String) = check(matches(hasDescendant(withText(text))))

fun ViewInteraction.doesNotHaveChildWithText(@StringRes textId: Int) = check(matches(not(hasDescendant(withText(textId)))))

fun ViewInteraction.doesNotHaveChildWithText(text: String) = check(matches(not(hasDescendant(withText(text)))))

fun ViewInteraction.isSelected() = check(ViewAssertions.matches(ViewMatchers.isSelected()))

fun ViewInteraction.isNotSelected() = check(ViewAssertions.matches(not(ViewMatchers.isSelected())))

fun ViewInteraction.textInputEditTextHasHint(@StringRes textId: Int) = check(matches(TextInputEditTextHintMatcher(textId)))

fun ViewInteraction.editTextHasError(@StringRes textId: Int) = check(matches(EditTextErrorMatcher(textId)))

fun ViewInteraction.hasChildCount(count: Int) = check(matches(recyclerViewSizeMatcher(count)))