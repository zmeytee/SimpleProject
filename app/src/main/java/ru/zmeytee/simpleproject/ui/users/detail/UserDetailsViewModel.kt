package ru.zmeytee.simpleproject.ui.users.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.User
import ru.zmeytee.simpleproject.repositories.UsersRepository
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(private val repository: UsersRepository): ViewModel() {

    private val _currentUser = MutableLiveData<User>()

    val currentUser: LiveData<User>
        get() = _currentUser

    fun getUser(id: Long) {
        viewModelScope.launch {
            val user = repository.getUserById(id)
            _currentUser.value = user
        }
    }
}