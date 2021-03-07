package ru.zmeytee.simpleproject.repositories

import ru.zmeytee.simpleproject.data.models.User

interface UsersRepository {

    suspend fun getAllUsers(): List<User>
    suspend fun getUserById(id: Long): User
    suspend fun addUser(user: User)
}