package ru.zmeytee.simpleproject.ui.users.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.User
import ru.zmeytee.simpleproject.repositories.UsersRepository
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(private val repository: UsersRepository): ViewModel() {

    fun addUser(user: User) {
        viewModelScope.launch {
            repository.addUser(user)
        }
    }
}