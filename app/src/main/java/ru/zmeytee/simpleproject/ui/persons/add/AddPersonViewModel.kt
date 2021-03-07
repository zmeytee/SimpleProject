package ru.zmeytee.simpleproject.ui.persons.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.zmeytee.simpleproject.data.models.Person
import ru.zmeytee.simpleproject.repositories.PersonsRepository
import javax.inject.Inject

@HiltViewModel
class AddPersonViewModel @Inject constructor(private val repository: PersonsRepository): ViewModel() {

    fun addPerson(person: Person) {
        viewModelScope.launch {
            repository.addPerson(person)
        }
    }
}