package com.nilearning.ecommerce

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.viewpager2.widget.ViewPager2
import com.nilearning.ecommerce.databinding.ActivityProductBinding
import com.nilearning.ecommerce.network.RetrofitInstance
import com.nilearning.ecommerce.ui.ImagesPagerAdapter
import com.nilearning.ecommerce.ui.TrendingViewModel
import com.nilearning.ecommerce.util.PreferenceHelper
import com.nilearning.ecommerce.util.TAG
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding
    private var imageId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageId = intent.extras?.getString("imageId")
        setSupportActionBar(binding.toolbar)

        fetchProductImages()

//        val viewModel: TrendingViewModel by viewModels()
//        viewModel.fetchTrending()
//
//        viewModel.unsplashImages.observe(this) {
//            if (it == null) return@observe
//            val imagesPagerAdapter = ImagesPagerAdapter(it!!)
//
//            val viewPager: ViewPager2 = binding.pager
//            viewPager.adapter = imagesPagerAdapter
//        }


        // Add menu items without overriding methods in the Activity
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.product_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return true
            }
        })
    }

    private fun fetchProductImages() {
        lifecycleScope.launch {
            val response = try {
                RetrofitInstance.commerceApi.getAllImages(1, 10)
            } catch (e: IOException) {
                Log.e(TAG(), "IOException, you might not have internet connection")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG(), "HttpException, unexpected response")
                return@launch
            }
            val imagesPagerAdapter = ImagesPagerAdapter(response)

            val viewPager: ViewPager2 = binding.pager
            viewPager.adapter = imagesPagerAdapter
            binding.indicator.setViewPager(viewPager)


            binding.myViewCountCarProductDetails.text = response[0].likes.toString()
            binding.myDateCarProductDetails.text = PreferenceHelper.getAgeDate(response[0].updatedAt)
            binding.myCityMainCarProductDetails.text = response[0].user.location
            binding.myCommonInfoCarProductDetails.text = response[0].user.username

            binding.myCityCarProductDetails.text = response[0].user.location
            binding.mySellerPhoneCarProductDetails.text = response[0].user.lastName
        }
    }
}