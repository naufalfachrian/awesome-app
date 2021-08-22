package com.naufalfachrian.awesomeapp.utils.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

abstract class PexelsPhotoItemView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract val titleTextView: TextView

    abstract val photoImageView: ImageView

}