package com.elpassion.android.commons.rxjava

import rx.Subscription
import rx.subscriptions.CompositeSubscription

fun Subscription.addTo(subscription: CompositeSubscription) = subscription.add(this)


