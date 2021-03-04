package ru.zmeytee.simpleproject.ui.persons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.Person
import ru.zmeytee.simpleproject.repositories.PersonsRepositoryImpl
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(private val repository: PersonsRepositoryImpl): ViewModel() {

    private val _persons = MutableLiveData<List<Person>>()
    private var currentJob: Job? = null

    val persons: LiveData<List<Person>>
        get() = _persons

    fun getAllPersons() {
        currentJob = viewModelScope.launch {
            val persons = repository.getAllPersons()
            _persons.value = persons
        }
    }

    fun getPersonById(id: Long) {
        currentJob = viewModelScope.launch {
            val person = repository.getPersonById(id)
            Timber.d("PERSON: name = ${(person as Person.AdvancedUser).name}")
        }
    }

    override fun onCleared() {
        super.onCleared()
        currentJob?.cancelChildren()
    }
}