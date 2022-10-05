package com.nilearning.ecommerce.network

import com.nilearning.ecommerce.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private val client = OkHttpClient.Builder().apply {
        readTimeout(15, TimeUnit.SECONDS)
        connectTimeout(15, TimeUnit.SECONDS)
        addInterceptor(NyInterceptor())
    }.build()

    val commerceApi: CommerceApi by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_COMMERCE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CommerceApi::class.java)
    }
}