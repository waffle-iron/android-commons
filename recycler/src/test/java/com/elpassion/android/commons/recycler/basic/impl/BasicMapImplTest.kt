package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicMap
import org.junit.Test

class BasicMapImplTest {

    @Test
    fun shouldCreateBasicMap(){
        val basicMap = BasicMapImpl<Int, String>()
        assert(basicMap is BasicMap<Int, String>)
    }
}