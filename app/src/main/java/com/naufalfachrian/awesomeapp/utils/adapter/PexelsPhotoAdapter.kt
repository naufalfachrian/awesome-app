package com.naufalfachrian.awesomeapp.utils.adapter

import androidx.paging.PagingDataAdapter
import com.naufalfachrian.awesomeapp.utils.comparator.PexelsPhotosComparator
import com.naufalfachrian.awesomeapp.utils.widget_ktx.loadImageFromNetwork
import com.naufalfachrian.pexels_api.entities.PexelsPhoto

abstract class PexelsPhotoAdapter : PagingDataAdapter<PexelsPhoto, PexelsPhotoItemView>(PexelsPhotosComparator()) {

    override fun onBindViewHolder(holder: PexelsPhotoItemView, position: Int) {
        val item = getItem(position)
        holder.titleTextView.text = item!!.photographer
        holder.photoImageView.loadImageFromNetwork(item.source.medium)
    }

}