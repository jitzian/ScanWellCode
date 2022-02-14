package com.example.scanwellchallenge.showRepos.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.scanwellchallenge.showRepos.viewmodel.MainViewModel
import java.lang.IllegalStateException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        throw IllegalStateException("View Model Not found")
    }
}