package ru.zmeytee.simpleproject.networking

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.zmeytee.simpleproject.data.models.Album
import ru.zmeytee.simpleproject.data.models.User

interface Api {

    @GET("users")
    suspend fun getAllUsers(): List<User.SimpleUser>

    @GET("users/{id}")
    suspend fun getUserById(
        @Path("id") id: Long
    ): User.AdvancedUser

    @GET("albums")
    suspend fun getUserAlbums(
        @Query("userId") userId: Long
    ): List<Album>

}