package ru.shmakova.myapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class JsonActor(
    val id: Int,
    val name: String,
    @SerialName("profile_path")
    val profilePicture: String
)
