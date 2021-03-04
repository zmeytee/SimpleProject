package ru.zmeytee.simpleproject.networking

import retrofit2.http.GET
import retrofit2.http.Path
import ru.zmeytee.simpleproject.data.models.Person

interface Api {

    @GET("users")
    suspend fun getAllUsers(): List<Person.SimpleUser>

    @GET("users/{id}")
    suspend fun getUserById(
        @Path("id") id: Long
    ): Person.AdvancedUser
}