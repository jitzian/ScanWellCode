package com.example.scanwellchallenge.rest.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.scanwellchallenge.rest.model.BadgeCounts

class BadgeCounts {
    @SerializedName("bronze")
    @Expose
    var bronze = 0

    @SerializedName("silver")
    @Expose
    var silver = 0

    @SerializedName("gold")
    @Expose
    var gold = 0
}