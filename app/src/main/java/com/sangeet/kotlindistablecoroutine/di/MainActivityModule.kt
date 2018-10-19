package com.sangeet.kotlindistablecoroutine.di

import android.content.SharedPreferences
import com.sangeet.kotlindistablecoroutine.interactor.ApiInteractor
import com.sangeet.kotlindistablecoroutine.viewmodel.MainActivityViewModel

class MainActivityModule(val sharedPreferences: SharedPreferences) : MainActivityComponent {

    override fun getViewModel(): MainActivityViewModel {
        return MainActivityViewModel(sharedPreferences, getApiInteractor())
    }

    override fun getApiInteractor(): ApiInteractor {
        return ApiInteractor()
    }

    override fun getViewModelClass(): Class<MainActivityViewModel> {
        return MainActivityViewModel::class.java
    }
}