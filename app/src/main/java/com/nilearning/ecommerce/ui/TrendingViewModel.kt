package com.nilearning.ecommerce.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nilearning.ecommerce.models.UnsplashItem
import com.nilearning.ecommerce.network.RetrofitInstance
import com.nilearning.ecommerce.util.TAG
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class TrendingViewModel : ViewModel() {

    var unsplashImages = MutableLiveData<List<UnsplashItem>?>().apply {
        value = null
    }

    fun fetchTrending() {
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.commerceApi.getAllImages(1, 10)
            } catch (e: IOException) {
                Log.e(TAG(), "IOException, you might not have internet connection")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG(), "HttpException, unexpected response")
                return@launch
            }
            unsplashImages.postValue(response)
        }
    }
}