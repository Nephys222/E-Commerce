package com.nilearning.ecommerce

import android.app.Application
import com.nilearning.ecommerce.util.PreferenceHelper.initializeImageLoader

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeImageLoader(this)
    }
}