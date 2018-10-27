package com.sangeet.kotlindistablecoroutine.interactor

import kotlinx.coroutines.delay
/**
 * @author sangeet.suresh on 19/10/18
 */
class ApiInteractor {

    //Mock of API response with time 4s
    suspend fun getData1(): String {
        delay(4000)
        return "Data1"
    }

    //Mock of API response with time 2s
    suspend fun getData2(): String {
        delay(2000)
        return "Data2"
    }
}