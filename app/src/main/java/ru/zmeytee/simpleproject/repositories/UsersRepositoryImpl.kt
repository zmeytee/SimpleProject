package ru.zmeytee.simpleproject.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.zmeytee.simpleproject.data.models.User
import ru.zmeytee.simpleproject.networking.Api
import timber.log.Timber
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val api: Api): UsersRepository {

    override suspend fun getAllUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            getAllRemoteUsers()
        }
    }

    private suspend fun getAllRemoteUsers(): List<User.SimpleUser> {
        return api.getAllUsers()
    }

    override suspend fun getUserById(id: Long): User {
        return withContext(Dispatchers.IO) {
            getRemoteUserById(id)
        }
    }

    private suspend fun getRemoteUserById(id: Long): User.AdvancedUser {
        return api.getUserById(id)
    }

    override suspend fun addUser(user: User) {
        withContext(Dispatchers.IO) {
//            Add person to DB (синхронизация с network в дальнейшем)???
            Timber.d("Action -> addPerson")
        }
    }
}