package com.example.scanwellchallenge.showRepos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scanwellchallenge.R
import com.example.scanwellchallenge.databinding.ActivityMainBinding
import com.example.scanwellchallenge.rest.model.Item
import com.example.scanwellchallenge.showRepos.adapters.RVCustomAdapter
import com.example.scanwellchallenge.showRepos.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainVM: MainViewModel
    private lateinit var adapter: RVCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        mainVM = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(binding.root)
        setupObservers()
        setupRV()
    }

    override fun onResume() {
        super.onResume().also {
            mainVM.fetchData()
        }
    }

    private fun setupObservers() {
        mainVM.data.observe(this, Observer { data ->
            when (data) {
                is MainViewModel.NetworkState.SuccessState -> {
                    Log.e(TAG, "setupObservers: $data")
                    adapter = RVCustomAdapter(data.resultApi.items)
                    binding.mRecyclerViewMainData.adapter = adapter
                }
                is MainViewModel.NetworkState.ErrorState -> {
                    //Error
                }
            }
        })
    }

    private fun setupRV() {
        binding.mRecyclerViewMainData.layoutManager = LinearLayoutManager(this)

    }

}