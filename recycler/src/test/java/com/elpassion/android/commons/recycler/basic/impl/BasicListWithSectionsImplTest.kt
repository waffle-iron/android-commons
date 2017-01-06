package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicListWithSections
import org.junit.Assert.assertEquals
import org.junit.Test

class BasicListWithSectionsImplTest {

    @Test
    fun shouldCreateBasicListWithSections() {
        val basicListWithSections = BasicListWithSectionsImpl<String, String>(mapOf())

        assert(basicListWithSections is BasicListWithSections<String, String>)
    }

    @Test
    fun shouldReturnCorrectSizeForOneEmptySection() {
        val basicListWithSections = BasicListWithSectionsImpl(mapOf("A" to listOf<String>()))

        assertEquals(basicListWithSections.size, 0)
    }

    @Test
    fun shouldReturnCorrectSizeForOneNotEmptySection() {
        val basicListWithSections = BasicListWithSectionsImpl(mapOf("A" to listOf("AA", "AB")))

        assertEquals(basicListWithSections.size, 2)
    }

    @Test
    fun shouldReturnCorrectSizeForTwoNotEmptySections() {
        val basicListWithSections = BasicListWithSectionsImpl(mapOf("A" to listOf("AA", "AB"), "B" to listOf("BA", "BB", "BC")))

        assertEquals(basicListWithSections.size, 5)
    }

//    @Test
//    fun shouldReturnCorrectValuesForGivenPositions() {
//        val basicListWithSections = BasicListWithSectionsImpl(mapOf("A" to listOf("A", "B", "ABC")))
//
//        assertEquals(basicListWithSections[0], "A")
//        assertEquals(basicListWithSections[1], "B")
//        assertEquals(basicListWithSections[2], "ABC")
//    }

//    @Test(expected = IndexOutOfBoundsException::class)
//    fun shouldThrowOutOfBoundsExceptionForNonExistingValue() {
//        val basicListWithSections = BasicListWithSectionsImpl<String>(listOf())
//
//        basicListWithSections[0]
//    }
//
//    @Test(expected = IndexOutOfBoundsException::class)
//    fun shouldContainCorrectValuesAndThrowForWrongPosition() {
//        val basicListWithSections = BasicListWithSectionsImpl(listOf("A", "B", "ABC"))
//
//        assertEquals(basicListWithSections[0], "A")
//        assertEquals(basicListWithSections[1], "B")
//        assertEquals(basicListWithSections[2], "ABC")
//
//        basicListWithSections[3]
//    }
//
//    @Test
//    fun shouldReturnValidValuesAfterSourceChange() {
//        val source = mutableListOf("A", "B", "C")
//        val basicListWithSections = BasicListWithSectionsImpl(source)
//
//        assertEquals(basicListWithSections[0], "A")
//        assertEquals(basicListWithSections[1], "B")
//        assertEquals(basicListWithSections[2], "C")
//
//        source[1] = "E"
//        source[2] = "P"
//
//        assertEquals(basicListWithSections[0], "A")
//        assertEquals(basicListWithSections[1], "E")
//        assertEquals(basicListWithSections[2], "P")
//    }
//
//    @Test
//    fun shouldReturnCorrectSizeWhenSourceChanges() {
//        val source = mutableListOf("A", "B", "C")
//        val basicListWithSections = BasicListWithSectionsImpl(source)
//        assertEquals(basicListWithSections.size, 3)
//        source.add("D")
//        assertEquals(basicListWithSections.size, 4)
//    }
}