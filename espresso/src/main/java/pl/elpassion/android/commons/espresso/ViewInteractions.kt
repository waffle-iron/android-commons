package pl.elpassion.android.commons.espresso

import android.support.annotation.IdRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId

fun onId(@IdRes viewId: Int) = onView(withId(viewId))