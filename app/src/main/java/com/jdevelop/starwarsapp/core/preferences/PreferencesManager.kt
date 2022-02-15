package com.jdevelop.starwarsapp.core.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

/**
 * Created by Jdevelop057 on 13/02/2022.
 */

enum class PreferencesKey(val value: String) {
    DARK("darkmode")
}

object PreferencesProvider {

    fun set(context: Context, key: PreferencesKey, value: String) {
        val editor = prefs(context).edit()
        editor.putString(key.value, value).apply()
    }

    fun string(context: Context, key: PreferencesKey): String? {
        return prefs(context).getString(key.value, null)
    }

    fun set(context: Context, key: PreferencesKey, value: Boolean) {
        val editor = prefs(context).edit()
        editor.putBoolean(key.value, value).apply()
    }

    fun bool(context: Context, key: PreferencesKey): Boolean {
        return prefs(context).getBoolean(key.value, false)
    }

    fun remove(context: Context, key: PreferencesKey) {
        val editor = prefs(context).edit()
        editor.remove(key.value).apply()
    }

    fun clear(context: Context) {
        val editor = prefs(context).edit()
        editor.clear().apply()
    }

    private fun prefs(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

}