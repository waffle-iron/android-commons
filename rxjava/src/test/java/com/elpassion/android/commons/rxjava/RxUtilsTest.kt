package com.elpassion.android.commons.rxjava

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import rx.exceptions.OnErrorNotImplementedException
import rx.observers.TestSubscriber
import rx.subjects.PublishSubject
import rx.subscriptions.CompositeSubscription

class RxUtilsTest {

    private val subject = PublishSubject.create<Unit>()

    private val subscription = CompositeSubscription()

    private val handler: (Throwable) -> Unit = mock()

    @Test
    fun shouldAddSubscriptionToCompositeSubscription() {

        subject
                .subscribe()
                .addTo(subscription)

        assert(subscription.hasSubscriptions())
    }

    @Test
    fun shouldUnsubscribeViaCompositeSubscription() {

        subject
                .subscribe()
                .addTo(subscription)

        assert(subject.hasObservers())

        subscription.clear()

        assert(!subject.hasObservers())
    }

    @Test
    fun shouldCatchRxError() {

        subject
                .catch<IllegalArgumentException> {
                    handler(it)
                }
                .subscribe()

        val exception = IllegalArgumentException()

        subject.onError(exception)

        verify(handler).invoke(exception)
    }

    @Test(expected = OnErrorNotImplementedException::class)
    fun shouldNotCatchRxError() {

        subject
                .catch<IllegalStateException> {
                    handler(it)
                }
                .subscribe()

        subject.onError(IllegalArgumentException())

        verify(handler, times(0)).invoke(any())
    }

    @Test
    fun shouldPassItemsThrough() {

        val subscriber = TestSubscriber<Any>()

        subject
                .catch<IllegalArgumentException> { }
                .subscribe(subscriber)

        subject.onNext(Unit)
        subject.onNext(Unit)

        subscriber.assertValues(Unit, Unit)
    }
}