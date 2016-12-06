package com.elpassion.android.commons.recycler.strategies.items

import com.elpassion.android.commons.recycler.components.group.impl.CachedMapItemsStrategy
import com.elpassion.android.commons.recycler.components.group.impl.MutableMapItemsStrategy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CachedItemsStrategyTest {

    @Test
    fun shouldReturnAllItemsFlattenedWhenAskedForAllItems() {
        val items = mutableMapOf(
                1 to mutableListOf(1, 2),
                2 to mutableListOf(3, 4))
        val strategy = CachedMapItemsStrategy(MutableMapItemsStrategy(items))
        val result = strategy.allItems()

        assertEquals(listOf(1, 2, 3, 4), result)
    }

    @Test
    fun shouldNotPerformFlatteningForTheSecondTimeWhenMapWasNotChanged() {
        val map = mutableMapOf(
                1 to mutableListOf(1, 2),
                2 to mutableListOf(3, 4))
        val strategy = CachedMapItemsStrategy(MutableMapItemsStrategy(map))

        val firstTime = strategy.allItems()
        val secondTime = strategy.allItems()

        assertTrue(firstTime === secondTime)
    }

    @Test
    fun shouldInvalidateCacheWhenMapWasChanged() {
        val items = mutableMapOf(
                1 to mutableListOf(1, 2),
                2 to mutableListOf(3, 4))
        val strategy = CachedMapItemsStrategy(MutableMapItemsStrategy(items))

        strategy.allItems()
        strategy.set(1, mutableListOf(1, 4))
        val secondTime = strategy.allItems()

        assertEquals(listOf(1, 4, 3, 4), secondTime)
    }
}