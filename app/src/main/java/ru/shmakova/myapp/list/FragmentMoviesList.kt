package ru.shmakova.myapp.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.shmakova.myapp.R
import ru.shmakova.myapp.data.DataUtils

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
            itemClickListener?.onItemClick()
        }
        adapter.submitList(DataUtils.movies)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.setHasFixedSize(true)
    }

    override fun onDetach() {
        super.onDetach()
        itemClickListener = null
    }

    interface ItemClickListener {
        fun onItemClick()
    }
}
