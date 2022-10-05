package com.nilearning.ecommerce.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nilearning.ecommerce.databinding.FragmentTrendingBinding

class TrendingFragment : Fragment() {

    private lateinit var binding: FragmentTrendingBinding
    private val viewModel: TrendingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrendingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.visibility = View.VISIBLE
        binding.trendingRefresh.isEnabled = true
        binding.trendingRecycler.layoutManager = LinearLayoutManager(context)

        if (viewModel.unsplashImages.value == null) viewModel.fetchTrending()
        viewModel.unsplashImages.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            showTrending()
        }
        binding.trendingRefresh.setOnRefreshListener {
            viewModel.fetchTrending()
        }
    }

    private fun showTrending() {
        if (viewModel.unsplashImages.value == null) return

        binding.trendingRefresh.isRefreshing = false

        val unsplashImages = viewModel.unsplashImages.value!!
        binding.progressBar.visibility = View.GONE

        binding.trendingRecycler.adapter = TrendingAdapter(unsplashImages, childFragmentManager)
    }
}