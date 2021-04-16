package ru.shmakova.myapp.features.details

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.shmakova.myapp.R
import ru.shmakova.myapp.models.Actor

class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.movie_actor_name)
    private val coverImageView: ImageView = itemView.findViewById(R.id.movie_actor_photo)

    fun bind(actor: Actor) {
        nameTextView.text = actor.name
        Glide.with(coverImageView)
            .load(actor.imageUrl)
            .centerCrop()
            .into(coverImageView)
    }
}
