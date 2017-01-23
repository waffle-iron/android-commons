package com.elpassion.android.commons.espresso

import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions

fun ViewInteraction.click(): ViewInteraction = perform(ViewActions.click())

fun ViewInteraction.typeText(text: String): ViewInteraction = perform(ViewActions.typeText(text))

fun ViewInteraction.replaceText(text: String): ViewInteraction = perform(ViewActions.replaceText(text))

fun ViewInteraction.pressImeActionButton(): ViewInteraction = perform(ViewActions.pressImeActionButton())