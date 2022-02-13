package com.example.scanwellchallenge.showRepos.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scanwellchallenge.constants.GlobalConstants
import com.example.scanwellchallenge.constants.GlobalConstants.Companion.MAX_TIME_OUT
import com.example.scanwellchallenge.dagger.components.DaggerComponentInjector
import com.example.scanwellchallenge.dagger.modules.NetworkModule
import com.example.scanwellchallenge.rest.RestApi
import com.example.scanwellchallenge.rest.model.ResultApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

class MainViewModel : ViewModel() {
    private val TAG = MainViewModel::class.java.simpleName
    private val injector = DaggerComponentInjector.builder()
        .networkModule(NetworkModule(GlobalConstants.baeUrl))
        .build()

    private lateinit var restApi: RestApi

    @Inject
    lateinit var retrofit: Retrofit

    init {
        inject()
    }

    private fun inject() {
        injector.inject(this)
        restApi = retrofit.create(RestApi::class.java)
    }

    private val _data by lazy {
        MutableLiveData<NetworkState>()
    }

    val data: LiveData<NetworkState>
        get() = _data

    fun fetchData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            withTimeout(MAX_TIME_OUT) {
                try {
                    Log.e(
                        TAG,
                        "fetchData: -->> ${NetworkState.SuccessState(restApi.fetchUserData())}"
                    )
                    _data.postValue(NetworkState.SuccessState(restApi.fetchUserData()))
                } catch (e: Exception) {
                    Log.e(TAG, "fetchData:Error: ${e.message}")
                    _data.postValue(NetworkState.ErrorState(e.message))
                }
            }
        }
    }

    sealed class NetworkState {
        class SuccessState(val resultApi: ResultApi) : NetworkState()
        class ErrorState(val message: String?) : NetworkState()
    }

}