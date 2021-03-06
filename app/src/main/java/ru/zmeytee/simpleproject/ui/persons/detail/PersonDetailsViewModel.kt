package ru.zmeytee.simpleproject.ui.persons.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.Person
import ru.zmeytee.simpleproject.repositories.PersonsRepository
import javax.inject.Inject

@HiltViewModel
class PersonDetailsViewModel @Inject constructor(private val repository: PersonsRepository): ViewModel() {

    private val _currentPerson = MutableLiveData<Person>()

    val currentPerson: LiveData<Person>
        get() = _currentPerson

    fun getPerson(id: Long) {
        viewModelScope.launch {
            val person = repository.getPersonById(id)
            _currentPerson.value = person
        }
    }
}