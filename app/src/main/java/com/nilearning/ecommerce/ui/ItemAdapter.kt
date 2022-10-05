package com.nilearning.ecommerce.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nilearning.ecommerce.R
import com.nilearning.ecommerce.databinding.CategoryRowBinding
import com.nilearning.ecommerce.models.DataModel


class ItemAdapter(private val mList: ArrayList<DataModel>) : RecyclerView.Adapter<ItemViewHolder>() {

    private var list: List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CategoryRowBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model = mList[position]
        holder.binding.itemTv.text = model.itemText
        val isExpandable = model.isExpandable
        holder.binding.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE
        if (isExpandable) {
            holder.binding.icArrow.setImageResource(R.drawable.ic_arrow_up)
        } else {
            holder.binding.icArrow.setImageResource(R.drawable.ic_arrow_down)
        }
        val adapter = NestedAdapter(list)
        holder.binding.childRv.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.binding.childRv.setHasFixedSize(true)
        holder.binding.childRv.adapter = adapter
        holder.binding.linearLayout.setOnClickListener {
            model.isExpandable = !model.isExpandable
            list = model.nestedList
            notifyItemChanged(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}

class ItemViewHolder(val binding: CategoryRowBinding) : RecyclerView.ViewHolder(binding.root)