package com.elpassion.android.commons.espresso.matchers

import android.support.test.espresso.matcher.BoundedMatcher
import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matcher

inline fun <reified T : View> createViewMatcher(
        crossinline matchesSafelyImpl: (view: T) -> Boolean,
        crossinline describeToImpl: (description: Description) -> Unit): Matcher<View> {

    return object : BoundedMatcher<View, T>(T::class.java) {

        override fun matchesSafely(item: T) = matchesSafelyImpl(item)

        override fun describeTo(description: Description) = describeToImpl(description)
    }
}
