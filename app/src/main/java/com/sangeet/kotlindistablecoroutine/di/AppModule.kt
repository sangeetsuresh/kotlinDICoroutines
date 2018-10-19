package com.sangeet.kotlindistablecoroutine.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * @author sangeet.suresh on 19/10/18
 */
class AppModule(private val context: Context) : AppComponent {
    override val mainActivityComponent: MainActivityComponent by lazy {
        MainActivityModule(getSharedPref())
    }

    override fun getSharedPref(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}