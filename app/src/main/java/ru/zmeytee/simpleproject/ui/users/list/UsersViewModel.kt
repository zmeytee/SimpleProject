package ru.zmeytee.simpleproject.ui.users.list

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
class UsersViewModel @Inject constructor(private val repository: UsersRepository): ViewModel() {

    private val _users = MutableLiveData<List<User>>()

    val users: LiveData<List<User>>
        get() = _users

    fun getAllUsers() {
        viewModelScope.launch {
            val users = repository.getAllUsers()
            _users.value = users
        }
    }
}