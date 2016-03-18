package com.elpassion.android.sharedpreferences

import android.support.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mockito
import org.mockito.Mockito.`when` as on

@RunWith(AndroidJUnit4::class)
class CachedSharedPreferencesTestCase {

    val repositoryMock = Mockito.mock(SharedPreferenceRepository::class.java)
    val cachingRepository = CachingSharedPreferenceRepository(repositoryMock)

    @Test
    fun twoReadsShouldCallRepositoryOnlyOnce() {
        cachingRepository.read("key")
        cachingRepository.read("key")

        Mockito.verify(repositoryMock, Mockito.times(1)).read(Matchers.anyString())
    }

    @Test
    fun twoCallsShouldReturnSameObject() {
        val any = Any()
        on(repositoryMock.read("key")).thenReturn(any)

        Assert.assertSame(any, cachingRepository.read("key"))
        Assert.assertSame(any, cachingRepository.read("key"))
    }
}