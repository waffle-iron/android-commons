package com.elpassion.android.commons.espresso

import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import org.hamcrest.core.IsNot.not

fun ViewInteraction.isDisplayed() = check(matches(ViewMatchers.isDisplayed()))

fun ViewInteraction.isNotDisplayed() = check(matches(not(ViewMatchers.isDisplayed())))

