package com.example.scanwellchallenge.showRepos.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.scanwellchallenge.constants.GlobalConstants.Companion.locationParam
import com.example.scanwellchallenge.constants.GlobalConstants.Companion.nameParam
import com.example.scanwellchallenge.databinding.DetailsBadgeBinding
import com.example.scanwellchallenge.safeLet
import com.example.scanwellchallenge.showRepos.viewmodel.DetailsViewModel

class DetailsDialog : DialogFragment() {
    private val TAG = DetailsDialog::class.simpleName
    private lateinit var binding: DetailsBadgeBinding
    private lateinit var detailsVM: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState).also {
            detailsVM = ViewModelProvider(this).get(DetailsViewModel::class.java)
            safeLet(
                arguments?.getString(locationParam),
                arguments?.getString(nameParam)
            ) { safeLocation, safeName ->
                detailsVM.setLocation(safeLocation)
                detailsVM.setName(safeName)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsBadgeBinding.inflate(layoutInflater)
        setupObservers()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun setupObservers() {
        detailsVM.location.observe(viewLifecycleOwner, Observer { location ->
            binding.mTextViewDetailsLocationValue.text = location
        })

        detailsVM.name.observe(viewLifecycleOwner, Observer { name ->
            binding.mTextViewDetailsNameValue.text = name
        })

    }

}