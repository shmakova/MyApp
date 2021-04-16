package ru.shmakova.myapp.features.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.shmakova.myapp.R
import ru.shmakova.myapp.models.Actor

class ActorsAdapter : ListAdapter<Actor, ActorViewHolder>(ActorsDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_actor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actor = getItem(position))
    }
}
