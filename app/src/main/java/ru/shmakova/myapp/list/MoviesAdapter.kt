package ru.shmakova.myapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.shmakova.myapp.R
import ru.shmakova.myapp.data.Movie

class MoviesAdapter(private val clickListener: (Movie) -> Unit) :
    ListAdapter<Movie, MovieViewHolder>(MoviesDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie = getItem(position))
        holder.itemView.setOnClickListener { clickListener(movie) }
    }
}
