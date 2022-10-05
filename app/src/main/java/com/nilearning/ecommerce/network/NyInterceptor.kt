package com.nilearning.ecommerce.network

import okhttp3.Interceptor
import okhttp3.Response

class NyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-type", "application/json")
            .build()
        return chain.proceed(request)
    }
}