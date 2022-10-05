package com.nilearning.ecommerce.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nilearning.ecommerce.databinding.FragmentCategoryBinding
import com.nilearning.ecommerce.models.DataModel


class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var mList: ArrayList<DataModel>
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.exRecycle.setHasFixedSize(true)
        binding.exRecycle.layoutManager = LinearLayoutManager(requireContext())

        mList = ArrayList()

        //list1

        //list1
        val nestedList1: MutableList<String> = ArrayList()
        nestedList1.add("Jams and Honey")
        nestedList1.add("Pickles and Chutneys")
        nestedList1.add("Readymade Meals")
        nestedList1.add("Chyawanprash and Health Foods")
        nestedList1.add("Pasta and Soups")
        nestedList1.add("Sauces and Ketchup")
        nestedList1.add("Namkeen and Snacks")
        nestedList1.add("Honey and Spreads")

        val nestedList2: MutableList<String> = ArrayList()
        nestedList2.add("Book")
        nestedList2.add("Pen")
        nestedList2.add("Office Chair")
        nestedList2.add("Pencil")
        nestedList2.add("Eraser")
        nestedList2.add("NoteBook")
        nestedList2.add("Map")
        nestedList2.add("Office Table")

        val nestedList3: MutableList<String> = ArrayList()
        nestedList3.add("Decorates")
        nestedList3.add("Tea Table")
        nestedList3.add("Wall Paint")
        nestedList3.add("Furniture")
        nestedList3.add("Bedsits")
        nestedList3.add("Certain")
        nestedList3.add("Namkeen and Snacks")
        nestedList3.add("Honey and Spreads")

        val nestedList4: MutableList<String> = ArrayList()
        nestedList4.add("Pasta")
        nestedList4.add("Spices")
        nestedList4.add("Salt")
        nestedList4.add("Chyawanprash")
        nestedList4.add("Maggie")
        nestedList4.add("Sauces and Ketchup")
        nestedList4.add("Snacks")
        nestedList4.add("Kurkure")

        val nestedList5: MutableList<String> = ArrayList()
        nestedList5.add("Jams and Honey")
        nestedList5.add("Pickles and Chutneys")
        nestedList5.add("Readymade Meals")
        nestedList5.add("Chyawanprash and Health Foods")
        nestedList5.add("Pasta and Soups")
        nestedList5.add("Sauces and Ketchup")
        nestedList5.add("Namkeen and Snacks")
        nestedList5.add("Honey and Spreads")

        val nestedList6: MutableList<String> = ArrayList()
        nestedList6.add("Pasta")
        nestedList6.add("Spices")
        nestedList6.add("Salt")
        nestedList6.add("Chyawanprash")
        nestedList6.add("Maggie")
        nestedList6.add("Sauces and Ketchup")
        nestedList6.add("Snacks")
        nestedList6.add("Kurkure")


        val nestedList7: MutableList<String> = ArrayList()
        nestedList7.add("Decorates")
        nestedList7.add("Tea Table")
        nestedList7.add("Wall Paint")
        nestedList7.add("Furniture")
        nestedList7.add("Bedsits")
        nestedList7.add("Certain")
        nestedList7.add("Namkeen and Snacks")
        nestedList7.add("Honey and Spreads")

        mList.add(DataModel(nestedList1, "Instant Food and Noodles"))
        mList.add(DataModel(nestedList2, "Stationary"))
        mList.add(DataModel(nestedList3, "Home Care"))
        mList.add(DataModel(nestedList4, "Grocery & Staples"))
        mList.add(DataModel(nestedList5, "Pet Care"))
        mList.add(DataModel(nestedList6, "Baby Care"))
        mList.add(DataModel(nestedList7, "Personal Care"))

        itemAdapter = ItemAdapter(mList)
        binding.exRecycle.adapter = itemAdapter

    }
}