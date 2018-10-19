package com.sangeet.kotlindistablecoroutine.extensions

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sangeet.kotlindistablecoroutine.App

/**
 * @author sangeet.suresh on 19/10/18
 */
fun Activity.appComponent() =
    (this.application as App).appComponent

fun <T : ViewModel> FragmentActivity.getViewModel(
    viewModelFactory: ViewModelProvider.Factory,
    clazz: Class<T>
) =
    ViewModelProviders.of(this, viewModelFactory).get(clazz)
