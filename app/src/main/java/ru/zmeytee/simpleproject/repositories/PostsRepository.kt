package ru.zmeytee.simpleproject.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.zmeytee.simpleproject.data.models.Post
import ru.zmeytee.simpleproject.networking.Api
import javax.inject.Inject

class PostsRepository @Inject constructor(private val api: Api) {

    suspend fun getPosts(userId: Long): List<Post> {
        return withContext(Dispatchers.IO) {
            api.getPosts(userId)
        }
    }
}