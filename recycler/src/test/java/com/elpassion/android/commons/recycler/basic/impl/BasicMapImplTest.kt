package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicMap
import org.junit.Test

class BasicMapImplTest {

    @Test
    fun shouldCreateBasicMapFromRegularMap(){
        val basicMap = BasicMapImpl<Int, String>(mapOf())
        assert(basicMap is BasicMap<Int, String?>)
    }

    @Test
    fun shouldReturnCorrectValuesForGivenKeys(){
        val basicMap = BasicMapImpl<Int, String>(mapOf(1 to "A", 2 to "B", -7 to "ABC"))
        assert(basicMap[1] == "A")
        assert(basicMap[2] == "B")
        assert(basicMap[-7] == "ABC")
    }

    @Test
    fun shouldReturnNullForNonExistingValues(){
        val basicMap = BasicMapImpl<Int, String>(mapOf(1 to "A", 2 to "B", -7 to "ABC"))
        assert(basicMap[-1] === null)
        assert(basicMap[3] === null)
        assert(basicMap[4] === null)
    }
}