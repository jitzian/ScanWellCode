package com.example.scanwellchallenge.rest.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.scanwellchallenge.rest.model.BadgeCounts

class Item {
    @SerializedName("badge_counts")
    @Expose
    var badgeCounts: BadgeCounts? = null

    @SerializedName("account_id")
    @Expose
    var accountId = 0

    @SerializedName("is_employee")
    @Expose
    var isIsEmployee = false
        private set

    @SerializedName("last_modified_date")
    @Expose
    var lastModifiedDate = 0

    @SerializedName("last_access_date")
    @Expose
    var lastAccessDate = 0

    @SerializedName("reputation_change_year")
    @Expose
    var reputationChangeYear = 0

    @SerializedName("reputation_change_quarter")
    @Expose
    var reputationChangeQuarter = 0

    @SerializedName("reputation_change_month")
    @Expose
    var reputationChangeMonth = 0

    @SerializedName("reputation_change_week")
    @Expose
    var reputationChangeWeek = 0

    @SerializedName("reputation_change_day")
    @Expose
    var reputationChangeDay = 0

    @SerializedName("reputation")
    @Expose
    var reputation = 0

    @SerializedName("creation_date")
    @Expose
    var creationDate = 0

    @SerializedName("user_type")
    @Expose
    var userType: String? = null

    @SerializedName("user_id")
    @Expose
    var userId = 0

    @SerializedName("accept_rate")
    @Expose
    var acceptRate = 0

    @SerializedName("location")
    @Expose
    var location: String? = null

    @SerializedName("website_url")
    @Expose
    var websiteUrl: String? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("profile_image")
    @Expose
    var profileImage: String? = null

    @SerializedName("display_name")
    @Expose
    var displayName: String? = null
    fun setIsEmployee(isEmployee: Boolean) {
        isIsEmployee = isEmployee
    }
}