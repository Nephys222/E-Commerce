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

//class ViewPagerAdapter(private val sections: List<String>
//) : RecyclerView.Adapter<ViewPagerViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding = FragmentMainBinding.inflate(layoutInflater, parent, false)
//        return ViewPagerViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
//        val sectionName = sections[position]
//        holder.binding.sectionLabel.text = sectionName
//    }
//
//    override fun getItemCount(): Int {
//        return sections.size
//    }
//}
//
//class ViewPagerViewHolder(val binding: FragmentMainBinding) : RecyclerView.ViewHolder(binding.root)