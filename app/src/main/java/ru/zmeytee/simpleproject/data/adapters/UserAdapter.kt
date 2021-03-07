package ru.zmeytee.simpleproject.data.adapters

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.zmeytee.simpleproject.data.models.User

class UserAdapter(onClick: (id: Long) -> Unit): AsyncListDifferDelegationAdapter<User>(PersonDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(UserAdapterDelegate(onClick))
    }

    class PersonDiffUtilCallback: DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return when {
                oldItem is User.SimpleUser && newItem is User.SimpleUser -> oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return when {
                oldItem is User.SimpleUser && newItem is User.SimpleUser -> oldItem == newItem
                else -> false
            }
        }
    }
}