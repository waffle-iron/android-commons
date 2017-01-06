package com.elpassion.android.commons.recycler.basic.impl

import com.elpassion.android.commons.recycler.basic.BasicListWithSections
import org.junit.Test

class BasicListWithSectionsImplTest {

    @Test
    fun shouldCreateBasicListWithSections() {
        val basicListWithSections = BasicListWithSectionsImpl<String, String>(mapOf())

        assert(basicListWithSections is BasicListWithSections<String, String>)
    }
}