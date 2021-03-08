package ru.zmeytee.simpleproject.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.zmeytee.simpleproject.data.models.Photo
import ru.zmeytee.simpleproject.databinding.ItemPhotoBinding

class PhotoAdapter(private val onClick: (id: Long) -> Unit) :
    ListAdapter<Photo, PhotoAdapter.Holder>(PhotoDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClick
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class PhotoDiffUtilCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

    }

    class Holder(
        private val binding: ItemPhotoBinding,
        onClick: (id: Long) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var photoId: Long? = null

        init {
            binding.root.setOnClickListener { photoId?.let(onClick) }
        }

        fun bind(item: Photo) {
            photoId = item.id

            with(binding) {
                photoTitleTextView.text = item.title
                photoThumbnailImageView.load(item.thumbnailUrl)
            }
        }
    }
}