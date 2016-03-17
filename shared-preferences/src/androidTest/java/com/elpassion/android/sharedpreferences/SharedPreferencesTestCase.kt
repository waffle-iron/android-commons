package com.elpassion.android.sharedpreferences

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SharedPreferencesTestCase {

    @Test
    fun shouldSaveStringToRepository() {
        val repository = createSharedPrefs<String>(getContext())
        val valueSaved = "someValue"
        repository.write("key", valueSaved)

        val valueRead = repository.read("key")
        Assert.assertEquals(valueSaved, valueRead)
    }

    data class SimpleStructure(val value: Int)

    @Test
    fun shouldSaveObjectToRepository() {
        val repository = createSharedPrefs<SimpleStructure>(getContext())
        val valueSaved = SimpleStructure(1)
        repository.write("key", valueSaved)

        val valueRead = repository.read("key")
        Assert.assertEquals(valueSaved, valueRead)
    }

    @Test
    fun shouldSaveListOfObjectsToRepository() {
        val repository = createSharedPrefs<List<SimpleStructure>>(getContext())
        val valueSaved = listOf(SimpleStructure(1))
        repository.write("key", valueSaved)

        val valueRead = repository.read("key")
        Assert.assertEquals(valueSaved, valueRead)
    }

    private fun getContext() = InstrumentationRegistry.getInstrumentation().targetContext
}