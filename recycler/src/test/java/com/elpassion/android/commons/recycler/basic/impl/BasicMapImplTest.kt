package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicMap
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class BasicMapImplTest {

    @Test
    fun shouldCreateBasicMapFromRegularMap() {
        val basicMap = BasicMapImpl<Int, String>(mapOf())

        assert(basicMap is BasicMap<Int, String?>)
    }

    @Test
    fun shouldReturnCorrectValuesForGivenKeys() {
        val basicMap = BasicMapImpl(mapOf(1 to "A", 2 to "B", -7 to "ABC"))

        assertEquals(basicMap[1], "A")
        assertEquals(basicMap[2], "B")
        assertEquals(basicMap[-7], "ABC")
    }

    @Test
    fun shouldReturnNullForNonExistingValues() {
        val basicMap = BasicMapImpl(mapOf(1 to "A", 2 to "B", -7 to "ABC"))

        assertNull(basicMap[-1])
        assertNull(basicMap[3])
        assertNull(basicMap[4])
    }
}