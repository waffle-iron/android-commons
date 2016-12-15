package com.elpassion.android.commons.espresso

import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions

fun ViewInteraction.click() = perform(ViewActions.click())

fun ViewInteraction.typeText(text: String) = perform(ViewActions.typeText(text))

fun ViewInteraction.replaceText(text: String) = perform(ViewActions.replaceText(text))

fun ViewInteraction.pressImeActionButton() = perform(ViewActions.pressImeActionButton())