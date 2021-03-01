package ru.zmeytee.simpleproject.ui.persons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.zmeytee.simpleproject.data.TestData
import ru.zmeytee.simpleproject.data.models.Person
import ru.zmeytee.simpleproject.repositories.PersonsRepository
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(private val repository: PersonsRepository): ViewModel() {

    private val _persons = MutableLiveData<List<Person>>()

    val persons: LiveData<List<Person>>
        get() = _persons

    fun initTestData() {
        _persons.postValue(TestData.usersList)
    }
}