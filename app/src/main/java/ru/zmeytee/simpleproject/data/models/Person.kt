package ru.zmeytee.simpleproject.data.models

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

sealed class Person {

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class SimpleUser(
        val id: Long,
        val name: String,
        val email: String,
        val phone: String
    ) : Person(), Parcelable

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class AdvancedUser(
        val id: Long,
        val name: String,
        val username: String,
        val email: String,
        val address: Address,
        val phone: String,
        val website: String,
        val company: Company
    ) : Person(), Parcelable {

        @JsonClass(generateAdapter = true)
        @Parcelize
        data class Address(
            val street: String,
            val suite: String,
            val city: String,
            val zipcode: String,
            val geo: Geo
        ) : Parcelable {

            @JsonClass(generateAdapter = true)
            @Parcelize
            data class Geo(
                val lat: Double,
                val lng: Double
            ) : Parcelable
        }

        @JsonClass(generateAdapter = true)
        @Parcelize
        data class Company(
            val name: String,
            val catchPhrase: String,
            val bs: String
        ) : Parcelable
    }
}