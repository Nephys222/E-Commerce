package com.nilearning.ecommerce.models


import com.google.gson.annotations.SerializedName

data class TopicSubmissions(
    @SerializedName("nature")
    val nature: Nature,
    @SerializedName("spirituality")
    val spirituality: Spirituality,
    @SerializedName("wallpapers")
    val wallpapers: Wallpapers
)