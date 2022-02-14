package com.example.scanwellchallenge.showRepos.callback

import com.example.scanwellchallenge.rest.model.Item

interface ItemClickListener {
    fun onItemClickListener(item: Item)
}