package com.elpassion.android.sharedpreferences

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class CachedSharedPreferencesTestCase {

    val spy = Mockito.mock(SharedPreferenceRepository::class.java)

    @Test
    fun twoReadsShouldCallRepositoryOnlyOnce() {
        val repository = CachedSharedPreferenceRepository(spy)
        repository.read("key")
        repository.read("key")

        Mockito.verify(spy, Mockito.times(1)).read(Matchers.anyString())
    }
}