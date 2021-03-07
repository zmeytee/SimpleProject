package ru.zmeytee.simpleproject.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.zmeytee.simpleproject.data.models.Person
import ru.zmeytee.simpleproject.networking.Api
import timber.log.Timber
import javax.inject.Inject

class PersonsRepositoryImpl @Inject constructor(private val api: Api): PersonsRepository {

    override suspend fun getAllPersons(): List<Person> {
        return withContext(Dispatchers.IO) {
            getAllRemoteUsers()
        }
    }

    private suspend fun getAllRemoteUsers(): List<Person.SimpleUser> {
        return api.getAllUsers()
    }

    override suspend fun getPersonById(id: Long): Person {
        return withContext(Dispatchers.IO) {
            getRemoteUserById(id)
        }
    }

    private suspend fun getRemoteUserById(id: Long): Person.AdvancedUser {
        return api.getUserById(id)
    }

    override suspend fun addPerson(person: Person) {
        withContext(Dispatchers.IO) {
//            Add person to DB (синхронизация с network в дальнейшем)
            Timber.d("Action -> addPerson")
        }
    }
}