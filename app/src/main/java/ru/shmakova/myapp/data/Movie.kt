package ru.shmakova.myapp.data

import androidx.annotation.DrawableRes

data class Movie(
    val name: String,
    @DrawableRes val cover: Int,
    val ageLimit: Int,
    val duration: Int,
    val reviews: Int,
    val rating: Float,
    val tagline: String,
    val like: Boolean
)
