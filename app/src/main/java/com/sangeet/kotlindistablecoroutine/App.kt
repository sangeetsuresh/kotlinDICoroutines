package com.sangeet.kotlindistablecoroutine

import android.app.Application
import com.sangeet.kotlindistablecoroutine.di.AppComponent
import com.sangeet.kotlindistablecoroutine.di.AppModule

/**
 * @author sangeet.suresh on 19/10/18
 */
class App : Application() {

    val appComponent: AppComponent by lazy {
        AppModule(applicationContext)
    }
}