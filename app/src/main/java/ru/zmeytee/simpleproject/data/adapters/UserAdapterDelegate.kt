package ru.zmeytee.simpleproject.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import ru.zmeytee.simpleproject.data.models.User
import ru.zmeytee.simpleproject.databinding.ItemUserBinding

class UserAdapterDelegate(
    private val onClick: (id: Long) -> Unit
) : AbsListItemAdapterDelegate<User.SimpleUser, User, UserAdapterDelegate.Holder>() {

    override fun isForViewType(item: User, items: MutableList<User>, position: Int): Boolean {
        return item is User.SimpleUser
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        return Holder(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClick
        )
    }

    override fun onBindViewHolder(item: User.SimpleUser, holder: Holder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class Holder(
        private val binding: ItemUserBinding,
        onClick: (id: Long) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var userId: Long? = null

        init {
            binding.root.setOnClickListener { userId?.let(onClick) }
        }

        fun bind(item: User.SimpleUser) {
            userId = item.id

            with(binding) {
                itemUserNameTextView.text = item.name
                itemUserEmailTextView.text = item.email
                itemUserPhoneTextView.text = item.phone
            }
        }
    }
}