package com.elpassion.android.commons.parcelable

import android.os.Parcel
import org.junit.Assert.assertEquals
import org.junit.Test

class ParcelBooleanTest {

    val parcel = Parcel.obtain()

    @Test
    fun shouldParcelFalse() {
        parcel.writeBoolean(false)
        parcel.setDataPosition(0)
        assertEquals(false, parcel.readBoolean())
    }

    @Test
    fun shouldParcelTrue() {
        parcel.writeBoolean(true)
        parcel.setDataPosition(0)
        assertEquals(true, parcel.readBoolean())
    }
}