package com.naufalfachrian.awesomeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naufalfachrian.awesomeapp.databinding.ItemListBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(private val itemView: ItemListBinding) : RecyclerView.ViewHolder(itemView.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //
    }

    override fun getItemCount(): Int {
        return 50
    }
}