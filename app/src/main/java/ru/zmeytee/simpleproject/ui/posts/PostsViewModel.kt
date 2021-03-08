package ru.zmeytee.simpleproject.ui.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.Post
import ru.zmeytee.simpleproject.repositories.PostsRepository
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val repository: PostsRepository): ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()

    val posts: LiveData<List<Post>>
        get() = _posts

    fun getPosts(userId: Long) {
        viewModelScope.launch {
            val posts = repository.getPosts(userId)
            _posts.value = posts
        }
    }
}