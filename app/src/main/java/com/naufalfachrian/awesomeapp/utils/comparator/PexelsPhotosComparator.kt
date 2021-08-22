package com.naufalfachrian.awesomeapp.utils.comparator

import androidx.recyclerview.widget.DiffUtil
import com.naufalfachrian.pexels_api.entities.PexelsPhoto

class PexelsPhotosComparator : DiffUtil.ItemCallback<PexelsPhoto>() {

    override fun areItemsTheSame(oldItem: PexelsPhoto, newItem: PexelsPhoto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PexelsPhoto, newItem: PexelsPhoto): Boolean {
        return oldItem == newItem
    }
}