package com.sangeet.kotlindistablecoroutine.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sangeet.kotlindistablecoroutine.R
import com.sangeet.kotlindistablecoroutine.databinding.ActivityMainBinding
import com.sangeet.kotlindistablecoroutine.di.ComponentProvider
import com.sangeet.kotlindistablecoroutine.di.MainActivityComponent
import com.sangeet.kotlindistablecoroutine.di.inject
import com.sangeet.kotlindistablecoroutine.extensions.appComponent
import com.sangeet.kotlindistablecoroutine.extensions.getViewModel
import com.sangeet.kotlindistablecoroutine.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity(), ComponentProvider<MainActivityComponent> {
    override val component: MainActivityComponent
        get() = appComponent().mainActivityComponent

    private val mainActivityViewFactory: ViewModelProvider.Factory by inject { getViewFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
                setLifecycleOwner(this@MainActivity)
                vm = getViewModel(mainActivityViewFactory, MainActivityViewModel::class.java)

            }.vm?.run {
            initialise()
        }
    }
}
