package com.elpassion.android.sharedpreferences

class CachedSharedPreferenceRepository<T>(private val repository: SharedPreferenceRepository<T>) : SharedPreferenceRepository<T> {

    private var cache = false

    override fun read(key: String): T? {
        if (cache) {
            return null
        } else {
            cache = true
            return repository.read(key)
        }
    }

    override fun write(key: String, value: T) = repository.write(key, value)
}