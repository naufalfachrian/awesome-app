package com.naufalfachrian.awesomeapp.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naufalfachrian.awesomeapp.databinding.ItemNoInternetConnectionBinding

class NoInternetConnectionAdapter : RecyclerView.Adapter<NoInternetConnectionAdapter.ViewHolder>() {

    class ViewHolder(itemView: ItemNoInternetConnectionBinding) : RecyclerView.ViewHolder(itemView.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemNoInternetConnectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // do nothing
    }

    override fun getItemCount(): Int {
        return 1
    }

}