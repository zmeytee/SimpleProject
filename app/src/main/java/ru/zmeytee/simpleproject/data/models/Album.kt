package ru.zmeytee.simpleproject.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Album(
    val userId: Long,
    val id: Long,
    val title: String
)