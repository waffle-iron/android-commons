package com.elpassion.android.commons.rxjava

import org.junit.Test
import rx.subjects.PublishSubject
import rx.subscriptions.CompositeSubscription

class RxUtilsTest {

    val subject = PublishSubject.create<Unit>()

    val compositeSubscription = CompositeSubscription()

    @Test
    fun shouldAddSubscriptionToCompositeSubscription() {

        subject
                .subscribe()
                .addTo(compositeSubscription)

        assert(compositeSubscription.hasSubscriptions())
    }

    @Test
    fun shouldUnsubscribeViaCompositeSubscription() {

        subject
                .subscribe()
                .addTo(compositeSubscription)

        assert(subject.hasObservers())

        compositeSubscription.clear()

        assert(!subject.hasObservers())
    }
}