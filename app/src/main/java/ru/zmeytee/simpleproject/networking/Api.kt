package ru.zmeytee.simpleproject.networking

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.zmeytee.simpleproject.data.models.*

interface Api {

    @GET("users")
    suspend fun getAllUsers(): List<User.SimpleUser>

    @GET("users/{id}")
    suspend fun getUser(
        @Path("id") id: Long
    ): User.AdvancedUser

    @GET("albums")
    suspend fun getAllAlbums(): List<Album>

    @GET("albums")
    suspend fun getAlbums(
        @Query("userId") userId: Long
    ): List<Album>

    @GET("photos")
    suspend fun getPhotos(
        @Query("albumId") albumId: Long
    ): List<Photo>

    @GET("posts")
    suspend fun getAllPosts(): List<Post>

    @GET("posts")
    suspend fun getPosts(
        @Query("userId") userId: Long
    ): List<Post>

    @GET("comments")
    suspend fun getComments(
        @Query("postId") postId: Long
    ): List<Comment>
}