package com.elpassion.android.commons.rxjava

import rx.Observable
import rx.Subscription
import rx.subscriptions.CompositeSubscription

fun Subscription.addTo(subscription: CompositeSubscription) = subscription.add(this)

inline fun <reified Ex : Throwable> Observable<*>.catch(crossinline action: (throwable: Ex) -> Unit) = this
        .onErrorResumeNext {
            if (it is Ex) {
                action(it)
                Observable.empty()
            } else {
                Observable.error(it)
            }
        }

