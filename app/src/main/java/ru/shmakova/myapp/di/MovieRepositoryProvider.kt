package ru.shmakova.myapp.di

import ru.shmakova.myapp.data.MovieRepository

internal interface MovieRepositoryProvider {
    fun provideMovieRepository(): MovieRepository
}
