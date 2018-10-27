package com.sangeet.kotlindistablecoroutine.viewmodel

import android.content.SharedPreferences
import android.util.Log
import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sangeet.kotlindistablecoroutine.interactor.ApiInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * @author sangeet.suresh on 19/10/18
 */
class MainActivityViewModel(
    private val sharedPreferences: SharedPreferences,
    private val apiInteractor: ApiInteractor
) : ViewModel(),
    CoroutineScope {

    var job: Job = Job()

    //All jobs will be cancelled when View Model is destroyed i.e when onCleared() is called
    // Setting IO thread as default Dispatcher
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    val data = MutableLiveData<String>()
    val progressBarVisibility = ObservableInt(View.GONE)

    fun initialise() {
        progressBarVisibility.set(View.VISIBLE)
        launch {
            val startTime = System.currentTimeMillis()
            Log.d("Coroutines", "Started API")
            val job1 = async {
                Log.d("Coroutines", "Job 1 execution ${Thread.currentThread()}")
                apiInteractor.getData1()
            }
            val job2 = async {
                Log.d("Coroutines", "Job 2 execution ${Thread.currentThread()}")
                apiInteractor.getData2()
            }
            //Parallel execution of job1 and job2
            val apiData1 = job1.await()
            val apiData2 = job2.await()
            val mergedApiData = apiData1 + apiData2
            Log.d("Coroutines", "Finished API${System.currentTimeMillis() - startTime}")
            //Switching to main thread for UI
            withContext(Dispatchers.Main) {
                Log.d("Coroutines", "UI ${Thread.currentThread()}")
                progressBarVisibility.set(View.GONE)
                data.value = mergedApiData
                sharedPreferences.edit().run {
                    putString("data", mergedApiData)
                    apply()
                }

            }
        }

    }

    //All coroutines started from this View Model will be cancelled when onCleared in invoked
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}