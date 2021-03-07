package ru.zmeytee.simpleproject.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.zmeytee.simpleproject.data.models.Album
import ru.zmeytee.simpleproject.databinding.ItemAlbumBinding

class AlbumAdapter(private val onClick: (albumId: Long) -> Unit) :
    ListAdapter<Album, AlbumAdapter.Holder>(AlbumDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClick
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class AlbumDiffUtilCallback : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem == newItem
        }

    }

    class Holder(
        private val binding: ItemAlbumBinding,
        onClick: (albumId: Long) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var albumId: Long? = null

        init {
            binding.root.setOnClickListener { albumId?.let(onClick) }
        }

        fun bind(item: Album) {
            albumId = item.id
            binding.albumTitleTextView.text = item.title
        }
    }
}