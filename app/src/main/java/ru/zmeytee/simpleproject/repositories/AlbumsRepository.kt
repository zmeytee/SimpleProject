package ru.zmeytee.simpleproject.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.zmeytee.simpleproject.data.models.Album
import ru.zmeytee.simpleproject.networking.Api
import javax.inject.Inject

class AlbumsRepository @Inject constructor(private val api: Api) {

    suspend fun getAllAlbums(userId: Long): List<Album> {
        return withContext(Dispatchers.IO) {
            api.getUserAlbums(userId)
        }
    }
}