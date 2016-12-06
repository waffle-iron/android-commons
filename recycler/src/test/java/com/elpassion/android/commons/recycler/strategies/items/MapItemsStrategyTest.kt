package com.elpassion.android.commons.recycler.strategies.items

import com.elpassion.android.commons.recycler.components.group.impl.MapItemsStrategy
import org.junit.Assert.assertEquals
import org.junit.Test

class MapItemsStrategyTest {

    @Test
    fun shouldReturnAllItemsFlattenedWhenAskedForAllItems() {
        val items = mutableMapOf(
                1 to mutableListOf(1, 2),
                2 to mutableListOf(3, 4))
        val strategy = MapItemsStrategy(items)
        val result = strategy.allItems()

        assertEquals(listOf(1, 2, 3, 4), result)
    }
}