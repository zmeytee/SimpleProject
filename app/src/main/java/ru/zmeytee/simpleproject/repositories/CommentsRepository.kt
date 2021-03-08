package ru.zmeytee.simpleproject.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.zmeytee.simpleproject.data.models.Comment
import ru.zmeytee.simpleproject.networking.Api
import javax.inject.Inject

class CommentsRepository @Inject constructor(private val api: Api) {

    suspend fun getComments(postId: Long): List<Comment> {
        return withContext(Dispatchers.IO) {
            api.getComments(postId)
        }
    }
}