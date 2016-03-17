package com.elpassion.android.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T : Any> createSharedPrefs(context: Context): SharedPreferenceRepository<T> {
    return object : SharedPreferenceRepository<T> {
        private val sharedPreferences: SharedPreferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }
        private val gson by lazy { Gson() }

        override fun write(key: String, value: T) {
            sharedPreferences.edit()
                    .putString(key, gson.toJson(value, value.javaClass))
                    .apply()
        }

        override fun read(key: String): T? {
            val value = sharedPreferences.getString(key, null)
            if (value == null) {
                return null
            } else {
                return gson.fromJson<T>(value, object : TypeToken<T>() {}.type)
            }
        }
    }
}
