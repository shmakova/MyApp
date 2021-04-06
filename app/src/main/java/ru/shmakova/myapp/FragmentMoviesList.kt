package ru.shmakova.myapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

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
        val item: View = view.findViewById(R.id.movie_card)
        item.setOnClickListener {
            itemClickListener?.onItemClick()
        }
    }

    override fun onDetach() {
        super.onDetach()
        itemClickListener = null
    }

    interface ItemClickListener {
        fun onItemClick()
    }
}

