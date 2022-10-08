package com.nilearning.ecommerce.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nilearning.ecommerce.databinding.ImagesRowBinding
import com.nilearning.ecommerce.models.UnsplashItem
import com.nilearning.ecommerce.util.PreferenceHelper


class ImagesPagerAdapter(private val productImages: List<UnsplashItem>
): RecyclerView.Adapter<ImagesPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesPagerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ImagesRowBinding.inflate(layoutInflater, parent, false)
        return ImagesPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImagesPagerViewHolder, position: Int) {
        val productImage = productImages[position]

        holder.binding.apply {
            PreferenceHelper.loadImage(productImage.urls.regular, showCase)
        }
    }

    override fun getItemCount(): Int {
        return productImages.size
    }
}

class ImagesPagerViewHolder(val binding: ImagesRowBinding) : RecyclerView.ViewHolder(binding.root)