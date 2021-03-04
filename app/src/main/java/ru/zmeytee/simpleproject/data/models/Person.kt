package ru.zmeytee.simpleproject.data.models

import com.squareup.moshi.JsonClass

sealed class Person {

    @JsonClass(generateAdapter = true)
    data class SimpleUser(
        val id: Long,
        val name: String,
        val email: String,
        val phone: String
    ) : Person()

    @JsonClass(generateAdapter = true)
    data class AdvancedUser(
        val id: Long,
        val name: String,
        val username: String,
        val email: String,
        val address: Address,
        val phone: String,
        val website: String,
        val company: Company
    ) : Person() {

        @JsonClass(generateAdapter = true)
        data class Address(
            val street: String,
            val suite: String,
            val city: String,
            val zipcode: String,
            val geo: Geo
        ) {

            @JsonClass(generateAdapter = true)
            data class Geo(
                val lat: Double,
                val lng: Double
            )
        }

        @JsonClass(generateAdapter = true)
        data class Company(
            val name: String,
            val catchPhrase: String,
            val bs: String
        )
    }
}