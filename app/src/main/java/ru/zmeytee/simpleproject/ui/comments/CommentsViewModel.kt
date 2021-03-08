package ru.zmeytee.simpleproject.ui.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.Comment
import ru.zmeytee.simpleproject.repositories.CommentsRepository
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(private val repository: CommentsRepository): ViewModel() {

    private val _comments = MutableLiveData<List<Comment>>()

    val comments: LiveData<List<Comment>>
        get() = _comments

    fun getComments(postId: Long) {
        viewModelScope.launch {
            val comments = repository.getComments(postId)
            _comments.value = comments
        }
    }
}