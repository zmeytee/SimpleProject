package ru.zmeytee.simpleproject.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.zmeytee.simpleproject.data.models.Post
import ru.zmeytee.simpleproject.databinding.ItemPostBinding

class PostAdapter(private val onClick: (id: Long) -> Unit): ListAdapter<Post, PostAdapter.Holder>(PostDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClick
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class PostDiffUtilCallback: DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }

    class Holder(
        private val binding: ItemPostBinding,
        onClick: (id: Long) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {

        private var postId: Long? = null

        init {
            binding.root.setOnClickListener { postId?.let(onClick) }
        }

        fun bind(item: Post) {
            postId = item.id

            with(binding) {
                postTitleTextView.text = item.title
                postBodyTextView.text = item.body
            }
        }
    }
}