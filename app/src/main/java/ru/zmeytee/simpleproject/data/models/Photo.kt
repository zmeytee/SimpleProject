package ru.zmeytee.simpleproject.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Photo(
    val albumId: Long,
    val id: Long,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)