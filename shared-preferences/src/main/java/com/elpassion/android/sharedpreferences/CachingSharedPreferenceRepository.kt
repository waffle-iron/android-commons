package com.elpassion.android.sharedpreferences

import java.util.*

class CachingSharedPreferenceRepository<T>(private val repository: SharedPreferenceRepository<T>) : SharedPreferenceRepository<T> {

    private val cacheMap = HashSet<String>()
    private val valueMap = HashMap<String, T?>()

    override fun read(key: String): T? {
        if (!cacheMap.contains(key)) {
            cacheMap.add(key)
            valueMap[key] = repository.read(key)
        }
        return valueMap[key]
    }

    override fun write(key: String, value: T) = repository.write(key, value)
}