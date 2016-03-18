package com.elpassion.android.sharedpreferences

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface SharedPreferenceRepository<T> {

    fun write(key: String, value: T)

    fun read(key: String): T?
}

inline fun <reified T> createSharedPrefs(sharedPreferences: Lazy<SharedPreferences>,
                                         gson: Lazy<Gson> = lazy { Gson() }): SharedPreferenceRepository<T> {
    return object : SharedPreferenceRepository<T> {
        private val type = object : TypeToken<T>() {}.type

        override fun write(key: String, value: T) {
            sharedPreferences.value.edit()
                    .putString(key, gson.value.toJson(value, type))
                    .apply()
        }

        override fun read(key: String): T? {
            val value = sharedPreferences.value.getString(key, null)
            if (value == null) {
                return null
            } else {
                return gson.value.fromJson<T>(value, type)
            }
        }
    }
}
