package com.sangeet.kotlindistablecoroutine.di

import com.sangeet.kotlindistablecoroutine.interactor.ApiInteractor
import com.sangeet.kotlindistablecoroutine.viewmodel.MainActivityViewModel

/**
 * @author sangeet.suresh on 19/10/18
 */
interface MainActivityComponent : ViewModelFactoryComponent<MainActivityViewModel> {

    fun getApiInteractor():ApiInteractor

}