package ru.shmakova.myapp.features.list

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.shmakova.myapp.R
import ru.shmakova.myapp.models.Movie

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.movie_title)
    private val coverImageView: ImageView = itemView.findViewById(R.id.movie_cover)
    private val likeImageView: ImageView = itemView.findViewById(R.id.movie_like_icon)
    private val ageLimitTextView: TextView = itemView.findViewById(R.id.movie_age_limit)
    private val genresTextView: TextView = itemView.findViewById(R.id.movie_genres)
    private val reviewsTextView: TextView = itemView.findViewById(R.id.movie_reviews)
    private val durationTextView: TextView = itemView.findViewById(R.id.movie_duration)
    private val stars: List<ImageView> = listOf(
        itemView.findViewById(R.id.movie_rating_star1),
        itemView.findViewById(R.id.movie_rating_star2),
        itemView.findViewById(R.id.movie_rating_star3),
        itemView.findViewById(R.id.movie_rating_star4),
        itemView.findViewById(R.id.movie_rating_star5)
    )

    private val activeLikeTint =
        ContextCompat.getColor(itemView.context, R.color.active_like_color)
    private val inactiveLikeTint =
        ContextCompat.getColor(itemView.context, R.color.inactive_like_color)
    private val activeStarColor =
        ContextCompat.getColor(itemView.context, R.color.active_star_color)
    private val inactiveStarColor =
        ContextCompat.getColor(itemView.context, R.color.inactive_star_color)

    fun bind(movie: Movie) {
        titleTextView.text = movie.title
        Glide.with(coverImageView)
            .load(movie.imageUrl)
            .centerCrop()
            .into(coverImageView);
        val likeTint = if (movie.isLiked) activeLikeTint else inactiveLikeTint
        ImageViewCompat.setImageTintList(likeImageView, ColorStateList.valueOf(likeTint))
        genresTextView.text = movie.genres.joinToString { it.name }
        ageLimitTextView.text = itemView.context.getString(R.string.movie_age_limit, movie.pgAge)
        reviewsTextView.text = itemView.context.getString(R.string.movie_reviews, movie.reviewCount)
        durationTextView.text =
            itemView.context.getString(R.string.movie_duration, movie.reviewCount)
        for (i in 0 until 5) {
            ImageViewCompat.setImageTintList(
                stars[i],
                ColorStateList.valueOf(if (i < movie.rating) activeStarColor else inactiveStarColor)
            )
        }
    }
}
