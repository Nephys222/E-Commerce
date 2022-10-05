package com.nilearning.ecommerce.util

import android.content.Context
import android.content.SharedPreferences
import android.text.format.DateUtils
import androidx.preference.PreferenceManager
import android.widget.ImageView
import coil.ImageLoader
import coil.load
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object PreferenceHelper {
    /**
     * for normal preferences
     */
    private lateinit var settings: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    /**
     * For sensitive data (like token)
     */
    private lateinit var authSettings: SharedPreferences
    private lateinit var authEditor: SharedPreferences.Editor

    lateinit var imageLoader: ImageLoader


    /**
     * set the context that is being used to access the shared preferences
     */
    fun initialize(context: Context) {
        settings = getDefaultSharedPreferences(context)
        editor = settings.edit()

        authSettings = getAuthenticationPreferences(context)
        authEditor = authSettings.edit()
    }

    fun putString(key: String?, value: String) {
        editor.putString(key, value).commit()
    }

    fun getString(key: String?, defValue: String?): String {
        return settings.getString(key, defValue)!!
    }

    fun getToken(): String {
        return authSettings.getString(TOKEN, "")!!
    }

    fun setToken(newValue: String) {
        authEditor.putString(TOKEN, newValue).apply()
    }

//    fun getUsername(): String {
//        return authSettings.getString(PreferenceKeys.USERNAME, "")!!
//    }
//
//    fun setUsername(newValue: String) {
//        authEditor.putString(PreferenceKeys.USERNAME, newValue).apply()
//    }

    private fun getDefaultSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    private fun getAuthenticationPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(AUTH_PREF_FILE, Context.MODE_PRIVATE)
    }

    fun initializeImageLoader(context: Context) {
        imageLoader = ImageLoader.Builder(context)
            .crossfade(true)
            .build()
    }

    fun loadImage(url: String?, target: ImageView) {
        target.load(url, imageLoader)
    }

    fun getAgeDate(date: String): CharSequence? {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        sdf.timeZone = TimeZone.getTimeZone("GMT")
        var time: Long = 0
        try {
            time = sdf.parse(date).time
        } catch (e: ParseException) {
            return null
        }
        return DateUtils.getRelativeTimeSpanString(time)

    }
}
