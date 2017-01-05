package com.elpassion.android.commons.recycler.basic

import org.junit.Assert.assertEquals
import org.junit.Test

class UtilsTest {

    @Test
    fun shouldCreateBasicMapWithAsBasicMap() {
        val source = mapOf(1 to "A")
        val basicMap = source.asBasicMap()

        assertEquals(basicMap[1], "A")
    }
}