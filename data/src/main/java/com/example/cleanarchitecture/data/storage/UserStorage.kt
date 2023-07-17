package com.example.cleanarchitecture.data.storage

import com.example.cleanarchitecture.data.storage.model.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}