package ru.zmeytee.simpleproject.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.Photo
import ru.zmeytee.simpleproject.repositories.PhotosRepository
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(private val repository: PhotosRepository): ViewModel() {

    private val _photos = MutableLiveData<List<Photo>>()

    val photos: LiveData<List<Photo>>
        get() = _photos

    fun getPhotos(albumId: Long) {
        viewModelScope.launch {
            val photos = repository.getPhotos(albumId)
            _photos.value = photos
        }
    }
}