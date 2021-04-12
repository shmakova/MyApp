package ru.shmakova.myapp.details

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.shmakova.myapp.R
import ru.shmakova.myapp.data.Actor

class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.movie_actor_name)
    private val coverImageView: ImageView = itemView.findViewById(R.id.movie_actor_photo)

    fun bind(actor: Actor) {
        nameTextView.text = actor.name
        coverImageView.setImageResource(actor.photo)
    }
}
