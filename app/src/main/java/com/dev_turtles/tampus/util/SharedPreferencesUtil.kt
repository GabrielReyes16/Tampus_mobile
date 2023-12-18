package com.dev_turtles.tampus.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.dev_turtles.tampus.data.model.User
import com.google.gson.Gson

class SharedPreferenceUtil private constructor(context: Context) {

    private val sharedPreference: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE)

    companion object {
        private const val SHARED_PREFERENCE_KEY = "SHARED_PREFERENCE_KEY"
        private const val USER = "USER_KEY"

        @Volatile
        private var INSTANCE: SharedPreferenceUtil? = null

        fun getInstance(context: Context): SharedPreferenceUtil =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: SharedPreferenceUtil(context).also { INSTANCE = it }
            }
    }

    fun saveUser(user: User) {
        val jsonUser = Gson().toJson(user)
        sharedPreference.edit { putString(USER, jsonUser) }
    }

    fun getUser(): User? {
        val jsonUser = sharedPreference.getString(USER, "")
        return Gson().fromJson(jsonUser, User::class.java)
    }

    fun clearUser() {
        sharedPreference.edit().remove(USER).apply()
    }
}
