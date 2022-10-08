package com.nilearning.ecommerce.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0-> TrendingFragment()
            1-> ChosenFragment()
            2-> CategoryFragment()
            else -> TrendingFragment()
        }
    }
}