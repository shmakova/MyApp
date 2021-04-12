package ru.shmakova.myapp.list

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import ru.shmakova.myapp.R
import ru.shmakova.myapp.data.Movie

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.movie_name)
    private val coverImageView: ImageView = itemView.findViewById(R.id.movie_cover)
    private val likeImageView: ImageView = itemView.findViewById(R.id.movie_like_icon)
    private val ageLimitTextView: TextView = itemView.findViewById(R.id.movie_age_limit)
    private val taglineTextView: TextView = itemView.findViewById(R.id.movie_tagline)
    private val reviewsTextView: TextView = itemView.findViewById(R.id.movie_reviews)
    private val durationTextView: TextView = itemView.findViewById(R.id.movie_duration)

    private val activeLikeTint =
        ContextCompat.getColor(itemView.context, R.color.active_like_color)
    private val inactiveLikeTint =
        ContextCompat.getColor(itemView.context, R.color.inactive_like_color)

    fun bind(movie: Movie) {
        nameTextView.text = movie.name
        coverImageView.setImageResource(movie.cover)
        val likeTint = if (movie.like) activeLikeTint else inactiveLikeTint
        ImageViewCompat.setImageTintList(likeImageView, ColorStateList.valueOf(likeTint));
        taglineTextView.text = movie.tagline
        ageLimitTextView.text = itemView.context.getString(R.string.movie_age_limit, movie.ageLimit)
        reviewsTextView.text = itemView.context.getString(R.string.movie_reviews, movie.reviews)
        durationTextView.text = itemView.context.getString(R.string.movie_duration, movie.reviews)
    }
}
