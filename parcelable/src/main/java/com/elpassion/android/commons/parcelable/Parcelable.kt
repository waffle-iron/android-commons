package com.elpassion.android.commons.parcelable

import android.os.Parcel
import android.os.Parcelable

fun Parcelable?.writeNullableToParcel(dest: Parcel, flags: Int) {
    dest.writeBoolean(this != null)
    if (this != null)
        writeToParcel(dest, flags)
}

fun <T> Parcelable.Creator<T>.createNullableFromParcel(source: Parcel) =
        if (source.readBoolean()) createFromParcel(source) else null
