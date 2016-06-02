package com.elpassion.android.commons.parcelable

import android.os.Parcel
import java.util.*

fun Parcel.readBoolean() = readInt() != 0

fun Parcel.writeBoolean(value: Boolean) = writeInt(if (value) 1 else 0)

fun Parcel.writeStringToStringMap(map: Map<String, String>) {
    writeInt(map.size)
    map.keys.forEach {
        writeString(it)
        writeString(map[it])
    }
}

fun Parcel.readStringToStringMap(): Map<String, String> {
    val mapSize = readInt()
    return HashMap<String, String>().apply {
        (0..mapSize - 1).forEach {
            this.put(readString(), readString())
        }
    }
}
