package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicList
import org.junit.Test

class BasicListImplTest {

    @Test
    fun shouldCreateBasicListFromRegularList() {
        val basicList = BasicListImpl<String>(listOf())

        assert(basicList is BasicList<String>)
    }
}