package ru.shmakova.myapp.features.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import ru.shmakova.myapp.R
import ru.shmakova.myapp.di.MovieRepositoryProvider
import ru.shmakova.myapp.models.Movie

class FragmentMoviesList : Fragment() {

    private var itemClickListener: ItemClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ItemClickListener) {
            itemClickListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.movies_list)
        val adapter = MoviesAdapter {
            itemClickListener?.onItemClick(it)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.setHasFixedSize(true)
        lifecycleScope.launch {
            val repository = (requireActivity() as MovieRepositoryProvider).provideMovieRepository()
            adapter.submitList(repository.loadMovies())
        }
    }

    override fun onDetach() {
        super.onDetach()
        itemClickListener = null
    }

    interface ItemClickListener {
        fun onItemClick(movie: Movie)
    }
}
