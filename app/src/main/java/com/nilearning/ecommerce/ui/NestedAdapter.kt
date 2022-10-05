package com.nilearning.ecommerce.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nilearning.ecommerce.databinding.NestedItemBinding


class NestedAdapter(private val mList: List<String>) : RecyclerView.Adapter<NestedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NestedItemBinding.inflate(layoutInflater, parent, false)
        return NestedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NestedViewHolder, position: Int) {
        holder.binding.nestedItemTv.text = mList[position]
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}

class NestedViewHolder(val binding: NestedItemBinding) : RecyclerView.ViewHolder(binding.root)