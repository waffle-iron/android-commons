package com.elpassion.android.parcelable

import android.os.Parcel
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class ParcelStringToStringMapTest {

    val parcel = Parcel.obtain()

    @Test
    fun shouldParcelEmptyMap() {
        val map: Map<String, String> = emptyMap()
        parcel.writeStringToStringMap(map)
        parcel.setDataPosition(0)
        assertEquals(map, parcel.readStringToStringMap())
    }

    @Test
    fun shouldParcelNonEmptyMap() {
        val map = mapOf("key" to "value")
        parcel.writeStringToStringMap(map)
        parcel.setDataPosition(0)
        assertEquals(map, parcel.readStringToStringMap())
    }
}