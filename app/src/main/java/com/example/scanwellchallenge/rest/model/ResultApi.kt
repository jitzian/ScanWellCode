package com.example.scanwellchallenge.rest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultApi {
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

    @SerializedName("has_more")
    @Expose
    var isHasMore = false

    @SerializedName("quota_max")
    @Expose
    var quotaMax = 0

    @SerializedName("quota_remaining")
    @Expose
    var quotaRemaining = 0
}