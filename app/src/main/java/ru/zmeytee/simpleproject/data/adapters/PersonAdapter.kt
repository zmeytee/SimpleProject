package ru.zmeytee.simpleproject.data.adapters

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.zmeytee.simpleproject.data.models.Person

class PersonAdapter(onClick: (id: Long) -> Unit): AsyncListDifferDelegationAdapter<Person>(PersonDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(UserAdapterDelegate(onClick))
    }

    class PersonDiffUtilCallback: DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return when {
                oldItem is Person.SimpleUser && newItem is Person.SimpleUser -> oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return when {
                oldItem is Person.SimpleUser && newItem is Person.SimpleUser -> oldItem == newItem
                else -> false
            }
        }
    }
}