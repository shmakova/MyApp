package ru.shmakova.myapp.features.list

import androidx.recyclerview.widget.DiffUtil
import ru.shmakova.myapp.models.Movie

class MoviesDiffUtilCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.title == newItem.title

    override fun areContentsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean {
        return oldItem == newItem
    }
}
