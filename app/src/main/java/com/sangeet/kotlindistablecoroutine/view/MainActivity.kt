package com.sangeet.kotlindistablecoroutine.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sangeet.kotlindistablecoroutine.R
import com.sangeet.kotlindistablecoroutine.databinding.ActivityMainBinding
import com.sangeet.kotlindistablecoroutine.extensions.appComponent
import com.sangeet.kotlindistablecoroutine.extensions.getViewModel
import com.sangeet.kotlindistablecoroutine.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    val mainActivityViewFacotry: ViewModelProvider.Factory by lazy {
        appComponent().mainActivityComponent.getViewFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
                setLifecycleOwner(this@MainActivity)
                vm = getViewModel(mainActivityViewFacotry, MainActivityViewModel::class.java)

            }.vm?.run {
            initialise()
        }
    }
}
