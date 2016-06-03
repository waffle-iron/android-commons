package com.elpassion.android.commons.espresso

import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.Visibility.GONE
import android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import org.hamcrest.core.IsNot.not

fun ViewInteraction.isDisplayed() = check(matches(ViewMatchers.isDisplayed()))

fun ViewInteraction.isNotDisplayed() = check(matches(not(ViewMatchers.isDisplayed())))

fun ViewInteraction.isGone() = check(matches(withEffectiveVisibility(GONE)))

fun ViewInteraction.doesNotExist() = check(ViewAssertions.doesNotExist())