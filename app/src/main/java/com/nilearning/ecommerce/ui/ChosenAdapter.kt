package com.nilearning.ecommerce.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.nilearning.ecommerce.databinding.ChosenRowBinding
import com.nilearning.ecommerce.models.UnsplashItem
import com.nilearning.ecommerce.util.PreferenceHelper

class ChosenAdapter(
    private val unsplashItems: List<UnsplashItem>,
    private val childFragmentManager: FragmentManager
) : RecyclerView.Adapter<ChosenViewHolder>() {

    override fun getItemCount(): Int {
        return unsplashItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChosenViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ChosenRowBinding.inflate(layoutInflater, parent, false)
        return ChosenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChosenViewHolder, position: Int) {
        val trending = unsplashItems[position]
        holder.binding.apply {
            PreferenceHelper.loadImage(trending.urls.regular, chosenImage)
            chosenTitle.text = trending.user.username
        }
    }
}

class ChosenViewHolder(val binding: ChosenRowBinding) :
    RecyclerView.ViewHolder(binding.root)
