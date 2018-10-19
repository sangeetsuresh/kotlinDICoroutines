package com.sangeet.kotlindistablecoroutine.di

import android.content.SharedPreferences

/**
 * @author sangeet.suresh on 19/10/18
 */
interface AppComponent {

    val mainActivityComponent: MainActivityComponent

    fun getSharedPref():SharedPreferences

}