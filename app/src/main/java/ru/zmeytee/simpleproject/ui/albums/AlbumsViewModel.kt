package ru.zmeytee.simpleproject.ui.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.Album
import ru.zmeytee.simpleproject.repositories.AlbumsRepository
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val repository: AlbumsRepository): ViewModel() {

    private val _albums = MutableLiveData<List<Album>>()

    val albums: LiveData<List<Album>>
        get() = _albums

    fun getAllAlbums(userId: Long) {
        viewModelScope.launch {
            val albums = repository.getAllAlbums(userId)
            _albums.value = albums
        }
    }
}