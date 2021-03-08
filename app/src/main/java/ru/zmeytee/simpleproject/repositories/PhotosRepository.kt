package ru.zmeytee.simpleproject.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.zmeytee.simpleproject.data.models.Photo
import ru.zmeytee.simpleproject.networking.Api
import javax.inject.Inject

class PhotosRepository @Inject constructor(private val api: Api) {

    suspend fun getPhotos(albumId: Long): List<Photo> {
        return withContext(Dispatchers.IO) {
            api.getPhotos(albumId)
        }
    }
}