package com.sangeet.kotlindistablecoroutine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author sangeet.suresh on 19/10/18
 */
class GenericViewModelFactory<T> constructor(
    private val clazz: Class<T>, val block: () -> T
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(clazz)) {
            return block() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}