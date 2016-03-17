package com.elpassion.android.sharedpreferences

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface SharedPreferenceRepository<T> {

    fun write(key: String, value: T)

    fun read(key: String): T?
}

inline fun <reified T> createSharedPrefs(context: Context): SharedPreferenceRepository<T> {
    return object : SharedPreferenceRepository<T> {
        private val type = object : TypeToken<T>() {}.type
        private val sharedPreferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }
        private val gson by lazy { Gson() }

        override fun write(key: String, value: T) {
            sharedPreferences.edit()
                    .putString(key, gson.toJson(value, type))
                    .apply()
        }

        override fun read(key: String): T? {
            val value = sharedPreferences.getString(key, null)
            if (value == null) {
                return null
            } else {
                return gson.fromJson<T>(value, type)
            }
        }
    }
}
