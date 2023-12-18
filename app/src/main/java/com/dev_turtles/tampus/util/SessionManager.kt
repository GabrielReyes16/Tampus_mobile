package com.dev_turtles.tampus.util

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object {
        private const val PREF_NAME = "TampusPreferences"
        private const val PRIVATE_MODE = 0
        private const val KEY_TOKEN = "token"
    }

    fun saveToken(token: String) {
        editor.putString(KEY_TOKEN, token)
        editor.apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }

    fun clearSession() {
        editor.clear()
        editor.apply()
    }
}
