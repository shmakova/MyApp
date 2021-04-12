package ru.shmakova.myapp.list

import androidx.recyclerview.widget.DiffUtil
import ru.shmakova.myapp.data.Movie

class MoviesDiffUtilCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: Movie,
        newItem: Movie
    ): Boolean {
        return oldItem == newItem
    }
}
