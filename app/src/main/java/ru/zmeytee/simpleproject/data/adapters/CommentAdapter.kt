package ru.zmeytee.simpleproject.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.zmeytee.simpleproject.data.models.Comment
import ru.zmeytee.simpleproject.databinding.ItemCommentBinding

class CommentAdapter(private val onClick: (id: Long) -> Unit): ListAdapter<Comment, CommentAdapter.Holder>(CommentDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClick
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class CommentDiffUtilCallback: DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }

    }

    class Holder(
        private val binding: ItemCommentBinding,
        onClick: (id: Long) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {

        private var commentId: Long? = null

        init {
            binding.root.setOnClickListener { commentId?.let(onClick) }
        }

        fun bind(item: Comment) {
            commentId = item.id

            with(binding) {
                commentNameTextView.text = item.name
                commentEmailTextView.text = item.email
                commentBodyTextView.text = item.body
            }
        }
    }
}
