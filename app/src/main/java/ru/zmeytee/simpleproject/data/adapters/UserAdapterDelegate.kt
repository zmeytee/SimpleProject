package ru.zmeytee.simpleproject.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import ru.zmeytee.simpleproject.data.models.Person
import ru.zmeytee.simpleproject.databinding.ItemUserBinding

class UserAdapterDelegate : AbsListItemAdapterDelegate<Person.User, Person, UserAdapterDelegate.Holder>() {

    override fun isForViewType(item: Person, items: MutableList<Person>, position: Int): Boolean {
        return item is Person.User
    }

    override fun onCreateViewHolder(parent: ViewGroup): Holder {
        return Holder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(item: Person.User, holder: Holder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class Holder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Person.User) {
            with(binding) {
                userName.text = item.name
                userEmail.text = item.email
                userPhone.text = item.phone
            }
        }
    }
}