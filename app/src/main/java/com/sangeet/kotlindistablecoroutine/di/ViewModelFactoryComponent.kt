package com.sangeet.kotlindistablecoroutine.di

import com.sangeet.kotlindistablecoroutine.viewmodel.GenericViewModelFactory

/**
 * @author sangeet.suresh on 19/10/18
 */
interface ViewModelFactoryComponent<T> {
    fun getViewFactory(): GenericViewModelFactory<T> =
        GenericViewModelFactory(
            getViewModelClass(),
            ::getViewModel
        )

    fun getViewModel(): T

    fun getViewModelClass(): Class<T>
}