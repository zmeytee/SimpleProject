package ru.zmeytee.simpleproject.data.models

sealed class Person {

    data class User(
        val id: Long,
        val name: String,
        val email: String,
        val phone: String
    ): Person()
}