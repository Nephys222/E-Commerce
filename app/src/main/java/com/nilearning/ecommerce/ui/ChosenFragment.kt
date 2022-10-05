package com.nilearning.ecommerce.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nilearning.ecommerce.R
import com.nilearning.ecommerce.databinding.FragmentChosenBinding
import com.nilearning.ecommerce.databinding.FragmentTrendingBinding

class ChosenFragment : Fragment() {

    private lateinit var binding: FragmentChosenBinding
    private val viewModel: TrendingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChosenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.visibility = View.VISIBLE
        binding.chosenRefresh.isEnabled = true
        binding.chosenRecycler.layoutManager = LinearLayoutManager(context)

        if (viewModel.unsplashImages.value == null) viewModel.fetchTrending()
        viewModel.unsplashImages.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            showChosen()
        }
        binding.chosenRefresh.setOnRefreshListener {
            viewModel.fetchTrending()
        }

    }

    private fun showChosen() {
        if (viewModel.unsplashImages.value == null) return

        binding.chosenRefresh.isRefreshing = false

        val unsplashImages = viewModel.unsplashImages.value!!
        binding.progressBar.visibility = View.GONE

        binding.chosenRecycler.adapter = ChosenAdapter(unsplashImages, childFragmentManager)
    }
}