package com.packt.chaptereight.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    @SerialName("createdAt")
    val createdAt: String = "",
    @SerialName("_id")
    val id: String,
    @SerialName("owner")
    val owner: String = "",
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("updatedAt")
    val updatedAt: String = "",
    val isFavorite: Boolean = false
)