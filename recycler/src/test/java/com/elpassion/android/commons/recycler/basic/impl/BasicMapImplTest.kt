package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicMap
import org.junit.Test

class BasicMapImplTest {

    @Test
    fun shouldCreateBasicMapFromRegularMap(){
        val basicMap = BasicMapImpl<Int, String>(mapOf())
        assert(basicMap is BasicMap<Int, String>)
    }
}