package com.naufalfachrian.awesomeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.naufalfachrian.awesomeapp.databinding.ItemListBinding

class ListAdapter : PexelsPhotoAdapter() {

    class ViewHolder(private val itemViewBinding: ItemListBinding) : PexelsPhotoItemView(itemViewBinding.root) {
        override val titleTextView: TextView
            get() = itemViewBinding.textView
        override val photoImageView: ImageView
            get() = itemViewBinding.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PexelsPhotoItemView {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

}