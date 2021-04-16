package ru.shmakova.myapp.features.details

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import ru.shmakova.myapp.R
import ru.shmakova.myapp.di.MovieRepositoryProvider
import ru.shmakova.myapp.models.Movie

private const val ARG_MOVIE_ID = "movie_id"

class FragmentMoviesDetails : Fragment() {

    private lateinit var coverImageView: ImageView
    private lateinit var ageLimitTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var genresTextView: TextView
    private lateinit var reviewsTextView: TextView
    private lateinit var storylineTextView: TextView
    private lateinit var castTextView: TextView
    private lateinit var stars: List<ImageView>
    private lateinit var actorsAdapter: ActorsAdapter
    private lateinit var actorsRecyclerView: RecyclerView

    private var backClickListener: BackClickListener? = null
    private var movieId: Int? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BackClickListener) {
            backClickListener = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getInt(ARG_MOVIE_ID) ?: throw IllegalArgumentException()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coverImageView = view.findViewById(R.id.movie_cover)
        ageLimitTextView = view.findViewById(R.id.movie_age_limit)
        titleTextView = view.findViewById(R.id.movie_title)
        genresTextView = view.findViewById(R.id.movie_genres)
        reviewsTextView = view.findViewById(R.id.movie_reviews)
        storylineTextView = view.findViewById(R.id.movie_storyline)
        castTextView = view.findViewById(R.id.movie_cast_title)
        stars = listOf(
            view.findViewById(R.id.movie_rating_star1),
            view.findViewById(R.id.movie_rating_star2),
            view.findViewById(R.id.movie_rating_star3),
            view.findViewById(R.id.movie_rating_star4),
            view.findViewById(R.id.movie_rating_star5)
        )

        actorsRecyclerView = view.findViewById(R.id.actors_list)
        actorsAdapter = ActorsAdapter()
        actorsRecyclerView.adapter = actorsAdapter
        actorsRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        actorsRecyclerView.setHasFixedSize(true)
        val backButton: View = view.findViewById(R.id.back)
        backButton.setOnClickListener { backClickListener?.onBackClick() }
        lifecycleScope.launch {
            val id = movieId ?: return@launch
            val repository = (requireActivity() as MovieRepositoryProvider).provideMovieRepository()
            val movie = repository.loadMovie(movieId = id)
            showMovie(movie ?: return@launch)
        }
    }

    private fun showMovie(movie: Movie) {
        titleTextView.text = movie.title
        Glide.with(coverImageView)
            .load(movie.detailImageUrl)
            .centerCrop()
            .into(coverImageView)
        genresTextView.text = movie.genres.joinToString { it.name }
        ageLimitTextView.text = getString(R.string.movie_age_limit, movie.pgAge)
        reviewsTextView.text = getString(R.string.movie_reviews, movie.reviewCount)
        storylineTextView.text = movie.storyLine
        if (movie.actors.isEmpty()) {
            castTextView.visibility = View.GONE
        } else {
            actorsAdapter.submitList(movie.actors)
        }
        val activeStarColor = ContextCompat.getColor(requireContext(), R.color.active_star_color)
        for (i in 0 until movie.rating) {
            ImageViewCompat.setImageTintList(stars[i], ColorStateList.valueOf(activeStarColor));
        }
    }

    override fun onDetach() {
        super.onDetach()
        backClickListener = null
    }

    companion object {
        @JvmStatic
        fun newInstance(movieId: Int) =
            FragmentMoviesDetails().apply {
                arguments = Bundle().apply {
                    putInt(ARG_MOVIE_ID, movieId)
                }
            }
    }

    interface BackClickListener {
        fun onBackClick()
    }
}
