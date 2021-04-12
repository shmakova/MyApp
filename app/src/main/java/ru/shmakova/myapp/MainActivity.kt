package ru.shmakova.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.shmakova.myapp.details.FragmentMoviesDetails
import ru.shmakova.myapp.list.FragmentMoviesList

class MainActivity : AppCompatActivity(), FragmentMoviesList.ItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, FragmentMoviesList())
                .commitAllowingStateLoss()
        }
    }

    override fun onItemClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, FragmentMoviesDetails())
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }
}
