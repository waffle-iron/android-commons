package com.elpassion.android.sharedpreferences

interface SharedPreferenceRepository<T : Any> {

    fun write(key: String, value: T)

    fun read(key: String): T?
}
