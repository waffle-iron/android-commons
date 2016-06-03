package com.elpassion.android.commons.espresso

import android.support.annotation.StringRes
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.Visibility.GONE
import android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.core.IsNot.not

fun ViewInteraction.isDisplayed() = check(matches(ViewMatchers.isDisplayed()))

fun ViewInteraction.isNotDisplayed() = check(matches(not(ViewMatchers.isDisplayed())))

fun ViewInteraction.isGone() = check(matches(withEffectiveVisibility(GONE)))

fun ViewInteraction.doesNotExist() = check(ViewAssertions.doesNotExist())

fun ViewInteraction.hasText(@StringRes textId: Int) = check(matches(withText(textId)))

fun ViewInteraction.hasText(text: String) = check(matches(withText(text)))

fun ViewInteraction.isEnabled() = check(matches(ViewMatchers.isEnabled()))

fun ViewInteraction.isDisabled() = check(matches(not(ViewMatchers.isEnabled())))
