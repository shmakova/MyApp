package ru.shmakova.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.shmakova.myapp.data.JsonMovieRepository
import ru.shmakova.myapp.data.MovieRepository
import ru.shmakova.myapp.di.MovieRepositoryProvider
import ru.shmakova.myapp.features.details.FragmentMoviesDetails
import ru.shmakova.myapp.features.list.FragmentMoviesList
import ru.shmakova.myapp.models.Movie

class MainActivity : AppCompatActivity(),
    FragmentMoviesList.ItemClickListener,
    FragmentMoviesDetails.BackClickListener,
    MovieRepositoryProvider {

    private val jsonMovieRepository = JsonMovieRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, FragmentMoviesList())
                .commitAllowingStateLoss()
        }
    }

    override fun onItemClick(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, FragmentMoviesDetails.newInstance(movieId = movie.id))
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

    override fun onBackClick() {
        supportFragmentManager.popBackStack()
    }

    override fun provideMovieRepository(): MovieRepository = jsonMovieRepository
}
