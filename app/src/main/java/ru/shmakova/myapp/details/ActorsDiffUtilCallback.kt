package ru.shmakova.myapp.details

import androidx.recyclerview.widget.DiffUtil
import ru.shmakova.myapp.data.Actor

class ActorsDiffUtilCallback : DiffUtil.ItemCallback<Actor>() {
    override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: Actor,
        newItem: Actor
    ): Boolean {
        return oldItem == newItem
    }
}
