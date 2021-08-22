package com.naufalfachrian.awesomeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naufalfachrian.awesomeapp.databinding.ItemGridBinding

class GridAdapter : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    class ViewHolder(private val itemView: ItemGridBinding) : RecyclerView.ViewHolder(itemView.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //
    }

    override fun getItemCount(): Int {
        return 50
    }

}