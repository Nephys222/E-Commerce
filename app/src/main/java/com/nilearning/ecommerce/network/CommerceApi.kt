package com.nilearning.ecommerce.network

import com.nilearning.ecommerce.BuildConfig
import com.nilearning.ecommerce.models.Unsplash
import com.nilearning.ecommerce.models.UnsplashItem
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface CommerceApi {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("next_page") per_page: Int
    ): List<UnsplashItem>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("page") page: Int,
        @Query("next_page") per_page: Int
    ): List<UnsplashItem>
}