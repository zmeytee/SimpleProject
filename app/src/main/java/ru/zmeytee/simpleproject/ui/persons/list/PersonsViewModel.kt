package ru.zmeytee.simpleproject.ui.persons.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.Person
import ru.zmeytee.simpleproject.repositories.PersonsRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(private val repository: PersonsRepositoryImpl): ViewModel() {

    private val _persons = MutableLiveData<List<Person>>()

    val persons: LiveData<List<Person>>
        get() = _persons

    fun getAllPersons() {
        viewModelScope.launch {
            val persons = repository.getAllPersons()
            _persons.value = persons
        }
    }
}