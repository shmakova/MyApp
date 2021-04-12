package ru.shmakova.myapp.data

import ru.shmakova.myapp.R

object DataUtils {
    val movies: List<Movie> = listOf(
        Movie(
            name = "Avengers: End Game",
            cover = R.drawable.movie_main_cover1,
            ageLimit = 13,
            duration = 137,
            reviews = 125,
            rating = 4f,
            tagline = "Action, Adventure, Drama",
            like = false
        ),
        Movie(
            name = "Tenet",
            cover = R.drawable.movie_main_cover2,
            ageLimit = 16,
            duration = 97,
            reviews = 98,
            rating = 5f,
            tagline = "Action, Sci-Fi, Thriller ",
            like = true
        ),
        Movie(
            name = "Black Widow",
            cover = R.drawable.movie_main_cover3,
            ageLimit = 13,
            duration = 102,
            reviews = 38,
            rating = 4f,
            tagline = "Action, Adventure, Sci-Fi",
            like = false
        ),
        Movie(
            name = "Wonder Woman 1984",
            cover = R.drawable.movie_main_cover4,
            ageLimit = 13,
            duration = 120,
            reviews = 74,
            rating = 5f,
            tagline = "Action, Adventure, Fantasy",
            like = false
        ),
        Movie(
            name = "Zack Snyder's Justice League",
            cover = R.drawable.movie_main_cover5,
            ageLimit = 18,
            duration = 242,
            reviews = 257,
            rating = 5f,
            tagline = " Action, Adventure, Fantasy",
            like = false
        ),
        Movie(
            name = "Thor: Ragnarok",
            cover = R.drawable.movie_main_cover6,
            ageLimit = 16,
            duration = 130,
            reviews = 527,
            rating = 4f,
            tagline = "Action, Adventure, Comedy",
            like = true
        ),
        Movie(
            name = "Guardians of the Galaxy Vol. 2",
            cover = R.drawable.movie_main_cover7,
            ageLimit = 16,
            duration = 136,
            reviews = 588,
            rating = 5f,
            tagline = "Action, Adventure, Comedy",
            like = true
        ),
        Movie(
            name = "Guardians of the Galaxy",
            cover = R.drawable.movie_main_cover8,
            ageLimit = 12,
            duration = 121,
            reviews = 726,
            rating = 4f,
            tagline = "Action, Adventure, Comedy",
            like = false
        )
    )

    val actors: List<Actor> = listOf(
        Actor(
            name = "Robert Downey Jr",
            photo = R.drawable.actor1
        ),
        Actor(
            name = "Chris Evans",
            photo = R.drawable.actor2
        ),
        Actor(
            name = "Mark Ruffalo",
            photo = R.drawable.actor3
        ),
        Actor(
            name = "Chris Hemsworth",
            photo = R.drawable.actor4
        )
    )
}
