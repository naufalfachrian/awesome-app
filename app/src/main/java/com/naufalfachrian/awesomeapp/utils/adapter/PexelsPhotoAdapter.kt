package com.naufalfachrian.awesomeapp.utils.adapter

import androidx.paging.PagingDataAdapter
import com.naufalfachrian.awesomeapp.utils.comparator.PexelsPhotosComparator
import com.naufalfachrian.pexels_api.entities.PexelsPhoto

abstract class PexelsPhotoAdapter : PagingDataAdapter<PexelsPhoto, PexelsPhotoItemView>(PexelsPhotosComparator()) {

    override fun onBindViewHolder(holder: PexelsPhotoItemView, position: Int) {
        holder.titleTextView.text = getItem(position)!!.photographer
    }

}