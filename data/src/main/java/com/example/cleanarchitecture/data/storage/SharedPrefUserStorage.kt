package com.example.cleanarchitecture.data.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.cleanarchitecture.data.storage.model.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lasName"


class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)


    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName  = sharedPreferences.getString(KEY_LAST_NAME, "default last name") ?: "default last name"
        return User(firstName = firstName, lastName = lastName)
    }
}