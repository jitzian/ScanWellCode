package com.example.scanwellchallenge.showRepos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {
    private val TAG = DetailsViewModel::class.java.simpleName

    private val _location by lazy {
        MutableLiveData<String>()
    }

    val location: LiveData<String>
        get() = _location

    fun setLocation(location: String) {
        _location.value = location
    }

    private val _name by lazy {
        MutableLiveData<String>()
    }

    val name: LiveData<String>
        get() = _name

    fun setName(name: String) {
        _name.value = name
    }

}