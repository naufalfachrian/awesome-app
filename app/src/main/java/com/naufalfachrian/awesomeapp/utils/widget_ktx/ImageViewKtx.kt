package com.naufalfachrian.awesomeapp.utils.widget_ktx

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageFromNetwork(urlString: String) {
    Log.d("url_img", urlString)
    Glide.with(this)
        .load(urlString)
        .into(this)
}