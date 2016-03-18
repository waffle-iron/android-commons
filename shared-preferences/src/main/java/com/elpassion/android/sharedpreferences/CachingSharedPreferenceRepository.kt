package com.elpassion.android.sharedpreferences

class CachingSharedPreferenceRepository<T>(private val repository: SharedPreferenceRepository<T>) : SharedPreferenceRepository<T> {

    private var cache = false
    private var value: T? = null

    override fun read(key: String): T? {
        if (!cache) {
            cache = true
            value = repository.read(key)
        }
        return value
    }

    override fun write(key: String, value: T) = repository.write(key, value)
}