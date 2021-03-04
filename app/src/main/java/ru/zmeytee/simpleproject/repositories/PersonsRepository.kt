package ru.zmeytee.simpleproject.repositories

import ru.zmeytee.simpleproject.data.models.Person

interface PersonsRepository {

    suspend fun getAllPersons(): List<Person>
    suspend fun getPersonById(id: Long): Person
}