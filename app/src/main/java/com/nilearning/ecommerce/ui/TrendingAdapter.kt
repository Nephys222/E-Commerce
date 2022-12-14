package com.nilearning.ecommerce.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.nilearning.ecommerce.ProductActivity
import com.nilearning.ecommerce.databinding.TrendingRowBinding
import com.nilearning.ecommerce.models.UnsplashItem
import com.nilearning.ecommerce.util.PreferenceHelper

class TrendingAdapter(
    private val unsplashItems: List<UnsplashItem>,
    private val childFragmentManager: FragmentManager
) : RecyclerView.Adapter<TrendingViewHolder>() {

    override fun getItemCount(): Int {
        return unsplashItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TrendingRowBinding.inflate(layoutInflater, parent, false)
        return TrendingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val trending = unsplashItems[position]
        holder.binding.apply {
            PreferenceHelper.loadImage(trending.urls.regular, productImage)
            customerTitle.text = trending.user.firstName
            productPrice.text = trending.likes.toString()
            productInfo.text = PreferenceHelper.getAgeDate(trending.createdAt)
            productDescription.text = trending.user.bio

            root.setOnClickListener {
                val productIntent = Intent(root.context, ProductActivity::class.java)
                productIntent.putExtra("imageId", trending.id)
                root.context.startActivity(productIntent)
            }
        }
    }
}

class TrendingViewHolder(val binding: TrendingRowBinding) : RecyclerView.ViewHolder(binding.root)
